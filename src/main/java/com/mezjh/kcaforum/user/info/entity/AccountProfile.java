package com.mezjh.kcaforum.user.info.entity;

import com.mezjh.kcaforum.user.message.entity.BadgesCount;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像Url
     */
    private String photoUrl;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 上次上线时间
     */
    private String latelyUpTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 标示数量
     */
    private BadgesCount badgesCount;

    public AccountProfile(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
