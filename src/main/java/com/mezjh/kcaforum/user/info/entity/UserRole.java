package com.mezjh.kcaforum.user.info.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色表
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class UserRole implements Serializable {

    private Long id;

    private Long userId;

    private Long roleId;
}
