package com.mezjh.kcaforum.user.info.service;

import com.mezjh.kcaforum.common.utils.BeanMapUtils;
import com.mezjh.kcaforum.common.utils.MdFive;
import com.mezjh.kcaforum.user.Comm;
import com.mezjh.kcaforum.user.info.dao.UserInfoMapper;
import com.mezjh.kcaforum.user.info.entity.AccountProfile;
import com.mezjh.kcaforum.user.info.entity.User;
import com.mezjh.kcaforum.user.info.vo.RegisterVo;
import com.mezjh.kcaforum.user.message.entity.BadgesCount;
import com.mezjh.kcaforum.user.message.service.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private MessageService messageService;

    @Override
    public User findUserExist(RegisterVo registerVo) {
        return userInfoMapper.findUserExist(registerVo);
    }

    @Override
    public int register(User user) {
        user.setLatelyUpTime((new Date()).toString());
        user.setPhotoUrl(Comm.HEAD_PHOTO_URL);
        user.setNickname(Comm.getBaseNickname(user.getPhone()));
        user.setPassword(MdFive.md5(user.getPassword()));
        user.setCreateTime(Comm.getNowTime());
        user.setUpdateTime(Comm.getNowTime());
        return userInfoMapper.register(user);
    }

    @Override
    public AccountProfile login(String username, String password) {
        User po = userInfoMapper.findByUsername(username);
        AccountProfile u = null;

        Assert.notNull(po, "账户不存在");

        Assert.state(StringUtils.equals(po.getPassword(), password), "密码错误");

        po.setLatelyUpTime(Comm.getNowTime());
        //int i = userInfoMapper.saveLateltTime(po);
        //System.out.println(i);
        u = BeanMapUtils.copyPassport(po);
//
//        BadgesCount badgesCount = new BadgesCount();
//        //badgesCount.setMessageCount(messageService.getUnReadMessageCount(u.getId()));
//        badgesCount.setMessageCount(1);
//        u.setBadgesCount(badgesCount);
        return u;
    }

    @Override
    public User getUserById(Long id) {
        return userInfoMapper.findUserById(id);
    }

    @Override
    public AccountProfile findProfile(Long id) {
        User po = userInfoMapper.findUserById(id);
        AccountProfile u = null;

        Assert.notNull(po, "账户不存在");

//		Assert.state(po.getStatus() != Const.STATUS_CLOSED, "您的账户已被封禁");
        po.setLatelyUpTime(Comm.getNowTime());

        u = BeanMapUtils.copyPassport(po);

        BadgesCount badgesCount = new BadgesCount();
        badgesCount.setMessageCount(1);

        u.setBadgesCount(badgesCount);

        return u;
    }

    @Override
    public User findUserByPhone(String phone) {
        return userInfoMapper.findUserByPhone(phone);
    }

    @Override
    public int userRegister(User user) {
        try {
            return userInfoMapper.userRegister(user);
        } catch (Exception e) {
            return 0;
        }
    }
}
