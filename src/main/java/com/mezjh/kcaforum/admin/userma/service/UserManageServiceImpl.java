package com.mezjh.kcaforum.admin.userma.service;

import com.mezjh.kcaforum.admin.userma.dao.UserManageMapper;
import com.mezjh.kcaforum.admin.userma.vo.PageVO;
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
    public List<User> getUserByPageNum(PageVO pageVO) {
        pageVO.setPageNum((pageVO.getPageNum() - 1) * pageVO.getPageSize());
        return userManageMapper.getUserByPageNum(pageVO);
    }

    @Override
    public User getUserById(Integer id) {
        return userManageMapper.getUserById(id);
    }
}
