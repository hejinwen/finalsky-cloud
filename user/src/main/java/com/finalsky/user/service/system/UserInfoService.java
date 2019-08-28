package com.finalsky.user.service.system;

import com.finalsky.user.entity.system.UserInfo;
import info.joyc.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.user.service.system.UserInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 用户信息表服务类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-22 11:32
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 根据Map条件查询UserInfo对象列表
     *
     * @param parameterMap Map条件集合
     * @return UserInfo对象列表
     */
    List<UserInfo> getUserInfoList(Map<String, Object> parameterMap);
}
