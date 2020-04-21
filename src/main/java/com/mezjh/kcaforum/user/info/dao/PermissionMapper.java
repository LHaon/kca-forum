package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Repository
@Mapper
public interface PermissionMapper {

    List<Permission> findAllByIds(Set<Long> ids);
    List<Permission> findAllByParentId(Long parentId, Sort sort);

    /**
     * count roleId
     * @param permId
     * @return
     */
    int countUsed(@Param("permId") Long permId);

    int maxWeight();
}
