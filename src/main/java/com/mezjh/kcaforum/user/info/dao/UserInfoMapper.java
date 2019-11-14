package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Mapper
@Repository
public interface UserInfoMapper {

    /**
     * 通过ID获取用户信息，出于安全考虑，这个方法不返回账号、密码、用户类型
     *
     * @param id
     * @return
     */
    @Select("select id,nickname from user where id=#{id}")
    User getUserInfoById(Integer id);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user values(null,#{username},#{password},1,#{nickname})")
    int userRegister(User user);
}
