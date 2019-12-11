package com.mezjh.kcaforum.user.info.entity;

import com.mezjh.kcaforum.system.entity.Account;
import lombok.Data;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Data
public class User extends Account {
    /**
     * 昵称
     */
    private String nickname;
}
