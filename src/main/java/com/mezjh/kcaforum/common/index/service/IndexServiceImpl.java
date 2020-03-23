package com.mezjh.kcaforum.common.index.service;

import com.mezjh.kcaforum.common.index.dao.IndexMapper;
import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.user.info.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService{

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<TextInfo> getIndexTextList() {
        return indexMapper.getIndexTextList();
    }

    @Override
    public List<User> getRecommendUser() {
        return indexMapper.getRecommendUser();
    }

    @Override
    public List<TextInfo> getPopularTextList() {
        return indexMapper.getPopularTextList();
    }
}
