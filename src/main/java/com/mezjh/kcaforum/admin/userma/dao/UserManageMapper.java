package com.mezjh.kcaforum.admin.userma.dao;

import com.mezjh.kcaforum.admin.userma.vo.PageVO;
import com.mezjh.kcaforum.user.info.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zjh
 * @date 2019/11/13
 */
@Repository
@Mapper
public interface UserManageMapper {

    /**
     * 获取用户列表
     *
     * @param pageVO
     * @return
     */
    List<User> getUserByPageNum(PageVO pageVO);

    /**
     * 根据ID显示用户详情
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);
}
