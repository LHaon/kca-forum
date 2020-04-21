package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.dao.UserRoleMapper;
import com.mezjh.kcaforum.user.info.entity.Role;
import com.mezjh.kcaforum.user.info.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public List<Long> listRoleIds(Long userId) {
        List<UserRole> list = userRoleMapper.findAllByUserId(userId);
        List<Long> roleIds = new ArrayList<>();
        if (null != list) {
            list.forEach(po -> roleIds.add(po.getRoleId()));
        }
        return roleIds;
    }

    @Override
    public List<Role> listRoles(Long userId) {
        List<Long> roleIds = listRoleIds(userId);
        return new ArrayList<>(roleService.findByIds(new HashSet<>(roleIds)).values());
    }

    @Override
    public Map<Long, List<Role>> findMapByUserIds(List<Long> userIds) {
        return null;
    }

    @Override
    public void updateRole(long userId, Set<Long> roleIds) {

    }
}
