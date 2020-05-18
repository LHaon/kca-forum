package com.mezjh.kcaforum.common.comment.dao;

import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 * @date 2020/5/17
 */
@Repository
@Mapper
public interface CommentMapper {
    /**
     * 发表评论
     * @param commentInfo
     * @return
     */
    int subComment(CommentInfo commentInfo);
    /**
     * 根据文章ID查询所有评论
     * @param textId
     * @return
     */
    List<CommentVo> findAllByTextId(Long textId);
}
