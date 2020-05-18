package com.mezjh.kcaforum.common.comment.service;

import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author zjh
 * @date 2020/5/17
 */
public interface CommentService {

    /**
     * 发表评论
     * @param commentVo
     * @return
     */
    void subComment(CommentVo commentVo);
    /**
     * 根据文章ID查询所有评论
     * @param textId
     * @return
     */
    List<CommentVo> findAllByTextId(Long textId);
}
