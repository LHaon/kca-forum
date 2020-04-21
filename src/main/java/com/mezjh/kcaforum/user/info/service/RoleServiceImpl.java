package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.dao.RoleMapper;
import com.mezjh.kcaforum.user.info.dao.RolePermissionMapper;
import com.mezjh.kcaforum.user.info.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public Map<Long, Role> findByIds(Set<Long> ids) {
        List<Role> list = roleMapper.findAllById(ids);
        Map<Long, Role> ret = new LinkedHashMap<>();
        list.forEach(po -> {
            Role vo = toVO(po);
            ret.put(vo.getId(), vo);
        });
        return ret;
    }

    private Role toVO(Role po) {
        Role r = new Role();
        r.setId(po.getId());
        r.setName(po.getName());
        r.setDescription(po.getDescription());
        r.setStatus(po.getStatus());

        r.setPermissions(rolePermissionMapper.findPermissionsByRoleId(r.getId()));
        return r;
    }
}
