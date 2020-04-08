package com.mezjh.kcaforum.common;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zjh
 * @date 2020/4/5
 */
public class BaseController {

    @Autowired
    private SiteOptions siteOptions;

    protected String view(String view) {
        return "/" + siteOptions.getValue("theme") + view;
    }
}
