package com.mezjh.kcaforum.admin.userma.service;

import com.mezjh.kcaforum.admin.userma.dao.UserManageMapper;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjh
 * @date 2019/11/13
 */
@Service("userManageService")
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    UserManageMapper userManageMapper;

    @Override
    public List<User> getUserByPageNum(int pageNum, int pageSize) {
        pageNum = (pageNum - 1) * pageSize;
        return userManageMapper.getUserByPageNum(pageNum, pageSize);
    }

    @Override
    public User getUserById(Integer id) {
        return userManageMapper.getUserById(id);
    }
}
