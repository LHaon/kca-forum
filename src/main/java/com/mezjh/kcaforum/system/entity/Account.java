package com.mezjh.kcaforum.system.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zjh
 * @date 2019/11/11
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    /**
     * 用户ID
     */
    private Integer accountId;
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
    private Integer accountType;
}
