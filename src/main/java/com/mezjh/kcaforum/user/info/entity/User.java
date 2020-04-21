package com.mezjh.kcaforum.user.info.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像地址
     */
    private String photoUrl;
    /**
     * 关注数
     */
    private Integer followCount;
    /**
     * 粉丝数
     */
    private Integer fansCount;
    /**
     * 文章数
     */
    private Integer textCount;
    /**
     * 字数
     */
    private Integer wordCount;
    /**
     * 获得喜欢数
     */
    private Integer collectionLikeCount;
    /**
     * 文章ID列表
     */
    private String textId;
    /**
     * 动态ID列表
     */
    private String dynamicId;
    /**
     * 最新评论ID列表
     */
    private String latestCommentId;
    /**
     * 热门ID列表
     */
    private String popularId;
    /**
     * 最近上线时间
     */
    private String latelyUpTime;

    private Integer status;
}
