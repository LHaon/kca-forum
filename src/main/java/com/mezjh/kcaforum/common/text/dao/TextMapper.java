package com.mezjh.kcaforum.common.text.dao;

import com.mezjh.kcaforum.common.text.entity.TextInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TextMapper {

    TextInfo getTextInfoDetail();

    /**
     * 发布文章
     * @param textInfo
     * @return
     */
    int subText(TextInfo textInfo);
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
    TextInfo getTextInfoById(Long id);

    /**
     * 增加阅读数
     * @param count
     */
    void readCountAdd(Integer count);

    /**
     * 编辑发布文章
     * @param textInfo
     */
    void updateText(TextInfo textInfo);
    /**
     * 删除文章
     * @param id
     */
    void deleteText(Long id);
}
