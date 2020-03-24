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
    private Integer textTypeId;
    private String typeName;
    private String textId;
    private Integer typeTextCount;
}
