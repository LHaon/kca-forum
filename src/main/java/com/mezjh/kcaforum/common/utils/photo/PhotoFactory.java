package com.mezjh.kcaforum.common.utils.photo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zjh
 * @date 2020/5/13
 */
@Component
public class PhotoFactory {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, PhotoBaseMethod> fileRepoMap = new HashMap<>();

    @PostConstruct
    public void init() {
        fileRepoMap.put("upyun", applicationContext.getBean(UpYunStorageImpl.class));
    }

    public PhotoBaseMethod get() {

        return fileRepoMap.get("upyun");
    }

}
