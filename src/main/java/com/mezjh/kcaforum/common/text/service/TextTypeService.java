package com.mezjh.kcaforum.common.text.service;

import com.mezjh.kcaforum.common.text.entity.TextType;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/24
 */
public interface TextTypeService {
    /**
     * 获取热门专题列表
     * @return
     */
    List<TextType> getPopularTypeList();
}
