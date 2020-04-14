package com.mezjh.kcaforum.common.text.controller;

import com.mezjh.kcaforum.common.BaseController;
import com.mezjh.kcaforum.common.Views;
import com.mezjh.kcaforum.common.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/texts")
public class TextController extends BaseController {

    @Autowired
    private TextService textService;


    @RequestMapping("editing")
    public String toEdit() {
        return  view(Views.TEXT_EDIT);
    }

}
