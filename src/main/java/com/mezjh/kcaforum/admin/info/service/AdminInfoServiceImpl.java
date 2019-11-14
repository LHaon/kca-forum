package com.mezjh.kcaforum.admin.info.service;

import com.mezjh.kcaforum.admin.info.dao.AdminInfoMapper;
import com.mezjh.kcaforum.admin.info.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjh
 * @date 2019/11/12
 */
@Service("infoService")
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    AdminInfoMapper adminInfoMapper;

    @Override
    public Admin getAdminInfoById(Integer id) {
        return adminInfoMapper.getAdminInfoById(id);
    }
}
