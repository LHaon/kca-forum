package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.entity.Permission;
import com.mezjh.kcaforum.user.info.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
public interface RolePermissionService {

    List<Permission> findPermissions(long roleId);
    void deleteByRoleId(long roleId);
    void add(Set<RolePermission> rolePermissions);
}
