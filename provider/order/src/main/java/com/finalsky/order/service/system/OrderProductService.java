package com.finalsky.order.service.system;

import com.finalsky.order.entity.system.OrderProduct;
import info.joyc.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.order.service.system.OrderProductService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单商品表服务类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
public interface OrderProductService extends BaseService<OrderProduct> {

    /**
     * 根据Map条件查询OrderProduct对象列表
     *
     * @param parameterMap Map条件集合
     * @return OrderProduct对象列表
     */
    List<OrderProduct> getOrderProductList(Map<String, Object> parameterMap);
}
