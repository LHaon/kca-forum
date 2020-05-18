package com.mezjh.kcaforum.common.comment.service;

import com.mezjh.kcaforum.common.comment.dao.CommentMapper;
import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import com.mezjh.kcaforum.user.Comm;
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

    @Override
    public void subComment(CommentVo commentVo) {
        CommentInfo commentInfo = new CommentInfo();

        commentInfo.setUserId(commentVo.getUserId());
        commentInfo.setTextId(commentVo.getTextId());
        commentInfo.setContent(commentVo.getContent());
        commentInfo.setCreateTime(Comm.getNowTime());
        commentInfo.setPid(commentVo.getPid());
        commentMapper.subComment(commentInfo);
        //评论增加
        //userEventService.identityComment(comment.getAuthorId(), true);
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
}
