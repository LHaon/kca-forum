package com.mezjh.kcaforum.common.comment.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Data
public class CommentInfo {

    private Long id;

    private Long pid;

    private Long textId;

    private String content;

    private String createTime;

    private Long userId;

    private Integer status;
}
