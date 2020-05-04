package com.mezjh.kcaforum.common.text.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextType {
    /**
     * 文章类型ID
     */
    private Long textTypeId;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 文章ID列表
     */
    private String textId;
    /**
     * 类型文章数量
     */
    private Integer typeTextCount;
}
