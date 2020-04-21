package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Repository
@Mapper
public interface RoleMapper {

    List<Role> findAllByStatus(Integer status);

    List<Role> findAllById(Set<Long> id);
}
