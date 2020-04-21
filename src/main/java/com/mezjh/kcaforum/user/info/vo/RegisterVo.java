package com.mezjh.kcaforum.user.info.vo;

import com.mezjh.kcaforum.user.info.entity.User;
import lombok.Data;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class RegisterVo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String code;

    public User toUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        return user;
    }
}
