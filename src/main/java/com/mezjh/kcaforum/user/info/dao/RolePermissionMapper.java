package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.Permission;
import com.mezjh.kcaforum.user.info.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Repository
@Mapper
public interface RolePermissionMapper {
    int deleteByRoleId(Long roleId);
    List<RolePermission> findAllByRoleId(Long roleId);
    List<Permission> findPermissionsByRoleId(Long id);
}
