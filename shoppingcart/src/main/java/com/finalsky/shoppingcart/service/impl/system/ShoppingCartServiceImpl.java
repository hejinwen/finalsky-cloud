package com.finalsky.shoppingcart.service.impl.system;

import com.finalsky.shoppingcart.entity.system.ShoppingCart;
import com.finalsky.shoppingcart.dao.system.ShoppingCartDao;
import com.finalsky.shoppingcart.service.system.ShoppingCartService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.shoppingcart.service.impl.system.ShoppingCartServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 购物车表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-26 16:38
 */
@Service
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart> implements ShoppingCartService {

    @Resource
    private ShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCart> getShoppingCartList(Map<String, Object> parameterMap) {
        return shoppingCartDao.queryForList(parameterMap);
    }
}
