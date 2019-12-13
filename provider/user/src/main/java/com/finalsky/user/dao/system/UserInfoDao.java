package com.finalsky.user.dao.system;

import com.finalsky.user.entity.system.UserInfo;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.user.dao.system.UserInfoDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 用户信息表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-22 11:32
 */
public interface UserInfoDao extends BaseDao<UserInfo> {

    /**
     * 根据参数集合查询用户信息表列表
     *
     * @param parameterMap 参数集合
     * @return 用户信息表列表
     */
    List<UserInfo> queryForList(Map<String, Object> parameterMap);
}
