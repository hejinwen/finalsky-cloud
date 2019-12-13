package com.finalsky.order.dao.system;

import com.finalsky.order.entity.system.OrderProduct;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.order.dao.system.OrderProductDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单商品表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
public interface OrderProductDao extends BaseDao<OrderProduct> {

    /**
     * 根据参数集合查询订单商品表列表
     *
     * @param parameterMap 参数集合
     * @return 订单商品表列表
     */
    List<OrderProduct> queryForList(Map<String, Object> parameterMap);
}
