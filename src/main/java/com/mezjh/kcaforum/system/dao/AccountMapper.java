package com.mezjh.kcaforum.system.dao;

import com.mezjh.kcaforum.system.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zjh
 * @date 2019/11/11
 */
@Mapper
@Repository
public interface AccountMapper {

    /**
     * 账号登陆
     *
     * @param username
     * @param password
     * @return
     */
    @Select("select id,user_type from user where username=#{username} and password=#{password}")
    Account accountToLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 通过用户名来查找用户
     *
     * @param username
     * @return
     */
    @Select("select id from user where username=#{username}")
    Account getUserByUsername(String username);
}
