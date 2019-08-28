package com.finalsky.shoppingcart.dao.system;

import com.finalsky.shoppingcart.entity.system.ShoppingCart;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.shoppingcart.dao.system.ShoppingCartDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 购物车表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-26 16:38
 */
public interface ShoppingCartDao extends BaseDao<ShoppingCart> {

    /**
     * 根据参数集合查询购物车表列表
     *
     * @param parameterMap 参数集合
     * @return 购物车表列表
     */
    List<ShoppingCart> queryForList(Map<String, Object> parameterMap);
}
