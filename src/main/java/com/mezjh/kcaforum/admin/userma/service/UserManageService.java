package com.mezjh.kcaforum.admin.userma.service;

import com.mezjh.kcaforum.user.info.entity.User;

import java.util.List;

/**
 * @author zjh
 * @date 2019/11/13
 */
public interface UserManageService {

    List<User> getUserByPageNum(int pageNum, int pageSize);

    User getUserById(Integer id);
}
