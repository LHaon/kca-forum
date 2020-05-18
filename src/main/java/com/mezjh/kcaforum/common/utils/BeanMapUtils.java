package com.mezjh.kcaforum.common.utils;

import com.mezjh.kcaforum.common.comment.entity.CommentInfo;
import com.mezjh.kcaforum.common.comment.vo.CommentVo;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.BeanUtils;

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

    public static CommentVo copy(CommentInfo po) {
        CommentVo ret = new CommentVo();
        BeanUtils.copyProperties(po, ret);
        return ret;
    }

}
