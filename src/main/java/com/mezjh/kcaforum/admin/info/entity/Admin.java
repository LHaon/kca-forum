package com.mezjh.kcaforum.admin.info.entity;

import com.mezjh.kcaforum.system.entity.Account;
import lombok.Data;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Data
public class Admin extends Account {
    private String nickname;
}
