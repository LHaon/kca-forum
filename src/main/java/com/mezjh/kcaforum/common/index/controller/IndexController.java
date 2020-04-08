package com.mezjh.kcaforum.common.index.controller;

import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.utils.common.Views;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = {"/","/index"})
    public String getIndex() {
        return view(Views.INDEX);
    }

    @GetMapping("/login")
    public String toLogin(){
        return view(Views.LOGIN);
    }
}