package com.mezjh.kcaforum.user.message.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Data
public class BadgesCount implements Serializable {
    /**
     * 消息数量
     */
    private Integer messageCount;
}
