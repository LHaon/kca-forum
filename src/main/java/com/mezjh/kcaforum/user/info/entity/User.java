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
    private Long id;
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
     * 最近上线时间
     */
    private String latelyUpTime;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 文章数
     */
    private Integer textCount;
    /**
     * 评论数
     */
    private Integer commentCount;

    private Integer status;
}
