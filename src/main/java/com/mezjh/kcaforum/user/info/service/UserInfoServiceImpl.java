package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.user.info.dao.UserInfoMapper;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public User getUserInfoById(Integer id) {
        return userInfoMapper.getUserInfoById(id);
    }

    @Override
    public int userRegister(User user) {
        try {
            return userInfoMapper.userRegister(user);
        } catch (Exception e) {
            return 0;
        }
    }
}
