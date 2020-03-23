package com.mezjh.kcaforum.common.index.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.index.service.IndexService;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/23
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/textList")
    public ApiResult<List<TextInfo>> getIndexTextList(){
        return ApiResult.success(indexService.getIndexTextList());
    }

    @GetMapping("/recommendUserList")
    public ApiResult<List<User>> getRecommendUserList(){
        return ApiResult.success(indexService.getRecommendUser());
    }
}