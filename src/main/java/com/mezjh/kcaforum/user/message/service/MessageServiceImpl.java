package com.mezjh.kcaforum.user.message.service;

import org.springframework.stereotype.Service;

/**
 * @author zjh
 * @date 2020/4/21
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService{
    @Override
    public Integer getUnReadMessageCount(Long id) {
        return null;
    }
}
