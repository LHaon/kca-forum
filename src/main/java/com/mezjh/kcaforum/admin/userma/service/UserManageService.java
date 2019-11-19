package com.mezjh.kcaforum.admin.userma.service;

import com.mezjh.kcaforum.admin.userma.vo.PageVO;
import com.mezjh.kcaforum.user.info.entity.User;

import java.util.List;

/**
 * @author zjh
 * @date 2019/11/13
 */
public interface UserManageService {

    List<User> getUserByPageNum(PageVO pageVO);

    User getUserById(Integer id);
}
