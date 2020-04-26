package com.mezjh.kcaforum.common.index.service;

import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.common.text.entity.TextInfoVo;
import com.mezjh.kcaforum.user.info.entity.User;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/23
 */
public interface IndexService {
    /**
     * 获取首页文章列表
     * @return
     */
    List<TextInfoVo> getIndexTextList();

}
