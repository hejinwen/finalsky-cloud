package com.finalsky.shoppingcart.service.system;

import com.finalsky.shoppingcart.entity.system.ShoppingCart;
import info.joyc.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.shoppingcart.service.system.ShoppingCartService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 购物车表服务类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-26 16:38
 */
public interface ShoppingCartService extends BaseService<ShoppingCart> {

    /**
     * 根据Map条件查询ShoppingCart对象列表
     *
     * @param parameterMap Map条件集合
     * @return ShoppingCart对象列表
     */
    List<ShoppingCart> getShoppingCartList(Map<String, Object> parameterMap);
}
