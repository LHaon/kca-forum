package com.mezjh.kcaforum.common.text.entity;

import com.mezjh.kcaforum.user.info.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Data
public class TextInfo implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 文章标签名
     */
    private String textTypeName;
    /**
     * 文章预览图片
     */
    private String photoPreview;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 喜欢数
     */
    private Integer likeCount;
    /**
     * 文章标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 预览
     */
    private String preview;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后更新时间
     */
    private String updateTime;
    /**
     * 阅读数
     */
    private Integer readCount;
    /**
     * 文章状态
     */
    private Integer status;
    /**
     * 文章用户
     */
    private User user;
}
