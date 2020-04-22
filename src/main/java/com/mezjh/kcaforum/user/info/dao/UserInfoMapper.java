package com.mezjh.kcaforum.user.info.dao;

import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.vo.RegisterVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Mapper
@Repository
public interface UserInfoMapper {

    User findUserExist(RegisterVo registerVo);

    /**
     * 通过ID获取用户信息，出于安全考虑，这个方法不返回账号、密码、用户类型
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    User findByUsername(String username);

    int saveLateltTime(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user values(null,#{username},#{password},1,#{nickname})")
    int userRegister(User user);
}
