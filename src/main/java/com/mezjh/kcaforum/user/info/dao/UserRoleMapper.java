package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Repository
@Mapper
public interface UserRoleMapper {
    List<UserRole> findAllByUserId(long userId);

    List<UserRole> findAllByUserIdIn(Collection<Long> userId);

    List<UserRole> findAllByRoleId(long roleId);

    /**
     * 清除权限
     *
     * @param userId 用户ID
     */
    int deleteByUserId(long userId);
}
