package com.mezjh.kcaforum.common.index.controller;

import com.mezjh.integrationkit.apiutils.ApiResult;
import com.mezjh.kcaforum.common.index.service.IndexService;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.entity.TextType;
import com.mezjh.kcaforum.common.text.service.TextTypeService;
import com.mezjh.kcaforum.common.utils.message.MessageUtil;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    private TextTypeService textTypeService;


    @GetMapping("/textList")
    public ApiResult<List<TextInfo>> getIndexTextList(String phone){
        return ApiResult.success(indexService.getIndexTextList());
    }

    @GetMapping("/popularTypeList")
    public ApiResult<List<TextType>> getPopularTypeList(){
        return ApiResult.success(textTypeService.getPopularTypeList());
    }

    @GetMapping("/recommendUserList")
    public ApiResult<List<User>> getRecommendUserList(){
        return ApiResult.success(indexService.getRecommendUser());
    }
}