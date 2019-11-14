package com.mezjh.kcaforum.system.entity;

import lombok.Data;

/**
 * @author zjh
 * @date 2019/11/11
 */
@Data
public class Account {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户类型 1 普通用户 2 管理员
     */
    private int userType;
}
