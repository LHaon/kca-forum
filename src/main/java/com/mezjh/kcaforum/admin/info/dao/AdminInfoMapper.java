package com.mezjh.kcaforum.admin.info.dao;

import com.mezjh.kcaforum.admin.info.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Mapper
@Repository
public interface AdminInfoMapper {

    /**
     * 通过ID获得管理员信息
     *
     * @param id
     * @return
     */
    @Select("select id,nickname from user where id=#{id}")
    Admin getAdminInfoById(Integer id);
}
