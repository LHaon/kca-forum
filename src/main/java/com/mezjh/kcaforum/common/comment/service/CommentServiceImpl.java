package com.mezjh.kcaforum.common.comment.service;

import com.mezjh.kcaforum.common.comment.dao.CommentMapper;
import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.service.TextService;
import com.mezjh.kcaforum.user.Comm;
import com.mezjh.kcaforum.user.info.dao.UserInfoMapper;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zjh
 * @date 2020/5/17
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private TextService textService;
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void subComment(CommentVo commentVo) {
        CommentInfo commentInfo = new CommentInfo();

        commentInfo.setUserId(commentVo.getUserId());
        commentInfo.setTextId(commentVo.getTextId());
        commentInfo.setContent(commentVo.getContent());
        commentInfo.setCreateTime(Comm.getNowTime());
        commentInfo.setPid(commentVo.getPid());
        commentMapper.subComment(commentInfo);
        TextInfo textInfo = textService.getTextInfoById(commentVo.getTextId());
        textInfo.setCommentCount(textInfo.getCommentCount() + 1);
        textService.updateText(textInfo);
        User user = userInfoService.getUserById(commentVo.getUserId());
        user.setCommentCount(user.getCommentCount() + 1);
        userInfoMapper.addCommentCount(user);
    }

    @Override
    public List<CommentVo> findAllByTextId(Long textId) {
        List<CommentVo> res = commentMapper.findAllByTextId(textId);
        for (CommentVo temp : res) {
            User user = userInfoService.getUserById(temp.getUserId());
            temp.setUser(user);
        }
        return res;
    }

    @Override
    public List<CommentVo> findAllByUserId(Long userId) {
        return commentMapper.findAllByUserId(userId);
    }
}
