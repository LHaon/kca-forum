package com.mezjh.kcaforum.common.text.dao;

import com.mezjh.kcaforum.common.text.entity.TextAttribute;
import com.mezjh.kcaforum.common.text.entity.TextInfoVo;

public interface TextMapper {

    TextInfoVo getTextInfoDetail();

    TextAttribute getTextAttributeById(Long id);
}
