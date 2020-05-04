package com.mezjh.kcaforum.common.text.service;

import com.mezjh.kcaforum.common.text.dao.TextMapper;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.utils.TextUtils;
import com.mezjh.kcaforum.user.Comm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service("textService")
public class TextServiceImpl implements TextService{

    @Autowired
    private TextMapper textMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public TextInfo getTextInfoById(Long id) {
        return textMapper.getTextInfoById(id);
    }

    @Override
    public Integer readCountAdd(Long textId, String ip, Integer count) {
        String key = ip + Long.toString(textId) + "read";
        if (redisTemplate.opsForValue().get(key) != null) {
            return count;
        }
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
    public void subText(TextInfo textInfo) {

        textInfo.setCreateTime(Comm.getNowTime());
        textInfo.setUpdateTime(Comm.getNowTime());
        textInfo.setStatus(textInfo.getStatus());

        // 设置预览内容
        if (StringUtils.isBlank(textInfo.getPreview())) {
            textInfo.setPreview(TextUtils.getText(textInfo.getContent(), 126));
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
            this.updateText(textInfo);
        } else {
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
