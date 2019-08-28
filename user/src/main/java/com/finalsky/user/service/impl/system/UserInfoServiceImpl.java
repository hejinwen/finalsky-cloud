package com.finalsky.user.service.impl.system;

import com.finalsky.user.entity.system.UserInfo;
import com.finalsky.user.dao.system.UserInfoDao;
import com.finalsky.user.service.system.UserInfoService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.user.service.impl.system.UserInfoServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 用户信息表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-22 11:32
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> getUserInfoList(Map<String, Object> parameterMap) {
        return userInfoDao.queryForList(parameterMap);
    }
}
