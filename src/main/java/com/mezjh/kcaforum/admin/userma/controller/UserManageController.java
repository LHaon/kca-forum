package com.mezjh.kcaforum.admin.userma.controller;

import com.mezjh.kcaforum.admin.userma.service.UserManageService;
import com.mezjh.kcaforum.admin.userma.vo.PageVO;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.utils.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zjh
 * @date 2019/11/13
 */
@RestController
@RequestMapping("admin/users")
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    @GetMapping
    public List<User> getUsersByPageNum(@RequestBody PageVO pageVO) {
        List<User> list = userManageService.getUserByPageNum(pageVO);
        return list;
    }

    @GetMapping("/{id}")
    public User getUserDetail(@PathVariable("id") Integer id) {
        return userManageService.getUserById(id);
    }

    @PostMapping("/{id}")
    public ApiResult updateUser() {
        return ApiResult.success();
    }

}
