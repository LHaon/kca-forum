package com.mezjh.kcaforum.common.text.service;

import com.mezjh.kcaforum.common.text.dao.TextTypeMapper;
import com.mezjh.kcaforum.common.text.entity.TextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/24
 */
@Service("textTypeService")
public class TextTypeServiceImpl implements TextTypeService{

    @Autowired
    private TextTypeMapper textTypeMapper;

    @Override
    public List<TextType> getPopularTypeList() {
        return textTypeMapper.getPopularTypeList();
    }
}
