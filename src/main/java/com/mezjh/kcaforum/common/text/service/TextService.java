package com.mezjh.kcaforum.common.text.service;

import com.mezjh.kcaforum.common.text.entity.TextInfo;

import java.util.List;

public interface TextService {

    /**
     * 发布文章
     * @param textInfoVo
     */
    void subText(TextInfo textInfoVo);
    /**
     * 通过用户ID获取用户文章
     * @param id
     * @return
     */
    List<TextInfo> getTextListByUserId(Long id);
    /**
     * 通过文章ID获取文章详情
     * @param id
     * @return
     */
    TextInfo getTextInfoById(Long id, Long currentUserId);

    /**
     * 增加阅读数
     * @param textId
     * @param ip
     * @param count
     */
    Integer readCountAdd(Long textId, String ip, Integer count);

    /**
     * 编辑发布文章
     * @param textInfo
     */
    void updateText(TextInfo textInfo);
    /**
     * 删除文章
     * @param id
     */
    void deleteText(Long id, Long userId);

    TextInfo getTextInfoById(Long id);

    List<TextInfo> getListByUserLikes(List<String> list);
}
