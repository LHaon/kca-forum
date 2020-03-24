package com.mezjh.kcaforum.common.index.dao;

import com.mezjh.kcaforum.common.text.entity.TextInfo;
import com.mezjh.kcaforum.user.info.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 * @date 2020/3/23
 */
@Repository
@Mapper
public interface IndexMapper {
    /**
     * 获取首页文章列表
     * @return
     */
    List<TextInfo> getIndexTextList();
    /**
     * 获取首页推荐作者列表
     * @return
     */
    List<User> getRecommendUser();
    /**
     * 获取热门文章列表
     * @return
     */
    List<TextInfo> getPopularTextList();
    /**
     * 通过用户ID得到用户信息
     * @param userId
     * @return
     */
    User getUserInfoByUserId(Integer userId);
}
