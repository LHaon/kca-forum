package com.mezjh.kcaforum.common.text.controller;

import com.mezjh.kcaforum.common.text.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/texts")
public class TextController {

    @Autowired
    private TextService textService;

}
