package com.finalsky.order.dao.system;

import com.finalsky.order.entity.system.OrderInfo;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.order.dao.system.OrderInfoDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单信息表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
public interface OrderInfoDao extends BaseDao<OrderInfo> {

    /**
     * 根据参数集合查询订单信息表列表
     *
     * @param parameterMap 参数集合
     * @return 订单信息表列表
     */
    List<OrderInfo> queryForList(Map<String, Object> parameterMap);
}
