package com.mezjh.kcaforum.common.utils.keywords;

import com.baidu.aip.nlp.AipNlp;
import com.mezjh.kcaforum.common.utils.keywords.baidu.AuthService;
import com.mezjh.kcaforum.common.utils.keywords.baidu.HttpUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author zjh
 * @date 2020/4/30
 */
@Component
public class KeywordsUtils {

    @Autowired
    private AuthService authService;

    private static final String url = "https://aip.baidubce.com/rest/2.0/solution/v1/text_censor/v2/user_defined";

    public String isKeywords(String context) {
        String res = HttpUtil.sendPost(url, "access_token=" + authService.getAuth() + "&text=" + context);
        return res;
    }

}
