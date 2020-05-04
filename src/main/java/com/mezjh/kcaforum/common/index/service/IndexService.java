package com.mezjh.kcaforum.common.index.service;

import com.mezjh.kcaforum.common.text.entity.TextInfo;

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
    List<TextInfo> getIndexTextList();

}
