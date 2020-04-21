package com.mezjh.kcaforum.user.info.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色-权限
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class RolePermission implements Serializable {
    private Long id;
    private Long roleId;
    private Long permissionId;
}
