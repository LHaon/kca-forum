package com.mezjh.kcaforum.common.text.dao;

import com.mezjh.kcaforum.common.text.entity.TextType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Repository
@Mapper
public interface TextTypeMapper {
    /**
     * 获取热门专题列表
     * @return
     */
    List<TextType> getPopularTypeList();
}
