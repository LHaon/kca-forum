package com.mezjh.kcaforum.common.utils;

import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;

/**
 * @author zjh
 * @date 2020/4/21
 */
public class BeanMapUtils {

    public static AccountProfile copyPassport(User vo) {
        AccountProfile res = new AccountProfile(vo.getId(), vo.getUsername());
        res.setNickname(vo.getNickname());
        res.setPhone(vo.getPhone());
        res.setPhotoUrl(vo.getPhotoUrl());
        res.setLatelyUpTime(vo.getLatelyUpTime());
        res.setStatus(vo.getStatus());
        return res;
    }

}
