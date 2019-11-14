package com.mezjh.kcaforum.system.service;

import com.mezjh.kcaforum.system.dao.AccountMapper;
import com.mezjh.kcaforum.system.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjh
 * @date 2019/11/11
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account accountToLogin(String username, String password) {
        return accountMapper.accountToLogin(username, password);
    }

    @Override
    public Account getUserByUsername(String username) {
        return accountMapper.getUserByUsername(username);
    }
}
