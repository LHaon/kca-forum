package com.mezjh.kcaforum.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * @author zjh
 * @date 2020/5/16
 */
@Component
@Slf4j
public class PopularTimeTask {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Scheduled(cron = "0 */1 * * * ?")
    public void updatepopular() throws ParseException {
        taskRun();
    }

    private void taskRun() {
        /**
         * 每隔一定时间刷新热门帖子列表
         */
        redisTemplate.delete("popularList");
    }

}
