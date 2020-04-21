package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.entity.Role;

import java.util.Map;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
public interface RoleService {

    Map<Long, Role> findByIds(Set<Long> ids);
}
