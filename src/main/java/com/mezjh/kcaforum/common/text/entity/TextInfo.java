package com.mezjh.kcaforum.common.text.entity;

import com.mezjh.kcaforum.user.info.entity.User;
import lombok.Data;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Data
public class TextInfo {
    /**
     * ID
     */
    private Integer textId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 文章类型ID
     */
    private Integer textTypeId;
    /**
     * 文章类型名
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
     * 预览
     */
    private String preview;
    /**
     * 文章markdown html
     */
    private String mdHtml;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后更新时间
     */
    private String updateTime;
    /**
     * 字数
     */
    private Integer wordCount;
    /**
     * 阅读数
     */
    private Integer readCount;
    /**
     * 文章所属用户
     */
    private User user;
}
