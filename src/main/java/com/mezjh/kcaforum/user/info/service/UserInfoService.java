package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.vo.RegisterVo;

/**
 * @author zjh
 * @date 2019/11/12
 */
public interface UserInfoService {
    /**
     * 查找用户是否存在
     * @param registerVo
     * @return
     */
    User findUserExist(RegisterVo registerVo);
    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    AccountProfile login(String username, String password);

    /**
     * 查找profile
     * @param id
     * @return
     */
    AccountProfile findProfile(Long id);

    User findUserByPhone(String phone);


    User getUserById(Long id);



    int userRegister(User user);
}
