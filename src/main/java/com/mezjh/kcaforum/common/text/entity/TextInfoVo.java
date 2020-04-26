package com.mezjh.kcaforum.common.text.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.mezjh.kcaforum.user.info.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjh
 * @date 2020/4/26
 */
@Data
public class TextInfoVo extends TextInfo implements Serializable {

    private String content;
    private User user;
    @JSONField(serialize = false)
    private TextAttribute textAttribute;
}
