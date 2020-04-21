package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.dao.PermissionMapper;
import com.mezjh.kcaforum.user.info.dao.RolePermissionMapper;
import com.mezjh.kcaforum.user.info.entity.Permission;
import com.mezjh.kcaforum.user.info.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService{

    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findPermissions(long roleId) {
        List<RolePermission> rps = rolePermissionMapper.findAllByRoleId(roleId);

        List<Permission> rets = null;
        if (rps != null && rps.size() > 0) {
            Set<Long> pids = new HashSet<>();
            rps.forEach(rp -> pids.add(rp.getPermissionId()));
            rets = permissionMapper.findAllByIds(pids);
        }
        return rets;
    }

    @Override
    public void deleteByRoleId(long roleId) {

    }

    @Override
    public void add(Set<RolePermission> rolePermissions) {

    }
}
