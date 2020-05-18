package com.mezjh.kcaforum.common.text.service;

import com.mezjh.kcaforum.common.text.dao.TextMapper;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.utils.MarkdownUtils;
import com.mezjh.kcaforum.common.utils.TextUtils;
import com.mezjh.kcaforum.user.Comm;
import com.mezjh.kcaforum.user.info.dao.UserInfoMapper;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("textService")
public class TextServiceImpl implements TextService{

    @Autowired
    private TextMapper textMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public TextInfo getTextInfoById(Long id, Long currentUserId) {
        TextInfo res = new TextInfo();
        res = this.getTextInfoById(id);
        //查询文章所属用户
        User user = userInfoService.getUserById(res.getUserId());
        if (currentUserId != null) {
            if (res.getUserLikeIds() != null && !res.getUserLikeIds().equals("")) {
                String temp = res.getUserLikeIds();
                String[] ids = res.getUserLikeIds().split(",");
                for(int i = 0;i < ids.length;i ++) {
                    if (ids[i].equals(Long.toString(currentUserId))) {
                        res.setUserLikeIds(temp);
                        break;
                    } else {
                        res.setUserLikeIds(null);
                    }
                }
            }
        } else {
            res.setUserLikeIds(null);
        }
        res.setUser(user);
        return res;
    }

    @Override
    public Integer readCountAdd(Long textId, String ip, Integer count) {
        String key = ip + Long.toString(textId) + "read";
        if (redisTemplate.opsForValue().get(key) != null) {
            return count;
        }
        redisTemplate.opsForZSet().incrementScore("popularList", Long.toString(textId), 1);
        textMapper.readCountAdd(count + 1);
        redisTemplate.opsForValue().set(key, "true" , 120, TimeUnit.SECONDS);
        return count + 1;
    }

    @Override
    public void updateText(TextInfo textInfo) {
        textInfo.setUpdateTime(Comm.getNowTime());
        textMapper.updateText(textInfo);
    }

    @Override
    public void deleteText(Long id, Long userId) {
        User user = userInfoService.getUserById(userId);
        user.setTextCount(user.getTextCount() - 1);
        userInfoMapper.addTextCount(user);
        textMapper.deleteText(id);
    }

    @Override
    public TextInfo getTextInfoById(Long id) {
        return textMapper.getTextInfoById(id);
    }

    @Override
    public List<TextInfo> getListByUserLikes(List<String> list) {
        List<TextInfo> res = textMapper.getListByUserLikes(list);
        for (TextInfo temp : res) {
            temp.setUser(userInfoService.getUserById(temp.getUserId()));
        }
        return res;
    }


    @Override
    public void subText(TextInfo textInfo) {

        textInfo.setCreateTime(Comm.getNowTime());
        textInfo.setUpdateTime(Comm.getNowTime());
        textInfo.setStatus(textInfo.getStatus());

        if (textInfo.getThumbnail() != null && !textInfo.getThumbnail().equals("")) {
            textInfo.setPhotoPreview(textInfo.getThumbnail());
        } else {
            textInfo.setPhotoPreview(null);
        }

        // 设置预览内容
        if (StringUtils.isBlank(textInfo.getPreview())) {
            textInfo.setPreview(TextUtils.getText(MarkdownUtils.renderMarkdown(textInfo.getContent()), 126));
        } else {
            textInfo.setPreview(textInfo.getPreview());
        }
        // 文章类型处理
//        List<TextType> typeList = textTypeService.getTextTypeList();
//        if (textInfoVo.getTextTypeName() == null) {
//
//        } else {
//            String[] types = textInfoVo.getTextTypeName().split(" ");
//            typeList.stream().forEach(textType -> {
//                for (int i = 0;i < types.length;i++) {
//                    TextType tar = new TextType();
//                    if (types[i].equals(textType)) {
//                        tar.setTypeTextCount(textType.getTypeTextCount() + 1);
//                    }
//                }
//            });
//        }
        if (textInfo.getId() != null && textInfo.getId() > 0) {
            TextInfo org = textMapper.getTextInfoById(textInfo.getId());
            textInfo.setLikeCount(org.getLikeCount());
            this.updateText(textInfo);
        } else {
            User user = userInfoService.getUserById(textInfo.getUserId());
            user.setTextCount(user.getTextCount() + 1);
            userInfoMapper.addTextCount(user);
            textMapper.subText(textInfo);
        }


//
//        postRepository.save(po);
//        tagService.batchUpdate(po.getTags(), po.getId());
//
//        PostAttribute attr = new PostAttribute();
//        attr.setContent(post.getContent());
//        attr.setEditor(post.getEditor());
//        attr.setId(po.getId());
//        postAttributeRepository.save(attr);
//
//        onPushEvent(po, PostUpdateEvent.ACTION_PUBLISH);
    }

    @Override
    public List<TextInfo> getTextListByUserId(Long id) {
        return textMapper.getTextListByUserId(id);
    }
}
