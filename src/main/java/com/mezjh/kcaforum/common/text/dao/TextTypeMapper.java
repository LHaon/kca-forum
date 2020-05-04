package com.mezjh.kcaforum.common.text.dao;

import com.mezjh.kcaforum.common.text.entity.TextType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.xml.soap.Text;
import java.util.List;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Repository
@Mapper
public interface TextTypeMapper {
    /**
     * 获取文章类型列表
     * @return
     */
    List<TextType> getTextTypeList();

    /**
     * 更新文章类型
     * @param textType
     * @return
     */
    int updateTextType(TextType textType);
}
