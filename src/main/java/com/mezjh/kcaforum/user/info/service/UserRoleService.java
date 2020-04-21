package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.entity.Role;
import com.mezjh.kcaforum.user.info.entity.UserRole;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
public interface UserRoleService {
    /**
     * 查询用户已有的角色Id
     * @param userId 用户ID
     * @return
     */
    List<Long> listRoleIds(Long userId);

    /**
     * 查询用户已有的角色 和 权限
     * @param userId 用户ID
     * @return
     */
    List<Role> listRoles(Long userId);

    Map<Long, List<Role>> findMapByUserIds(List<Long> userIds);

    /**
     * 修改用户角色
     * @param userId 用户ID
     * @param roleIds 要授权的角色ID
     */
    void updateRole(long userId, Set<Long> roleIds);
}
