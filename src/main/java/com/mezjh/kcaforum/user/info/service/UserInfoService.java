package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.entity.User;

/**
 * @author zjh
 * @date 2019/11/12
 */
public interface UserInfoService {

    User getUserInfoById(Integer id);

    int userRegister(User user);
}
