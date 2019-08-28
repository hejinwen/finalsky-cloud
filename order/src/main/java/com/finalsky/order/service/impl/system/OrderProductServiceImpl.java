package com.finalsky.order.service.impl.system;

import com.finalsky.order.entity.system.OrderProduct;
import com.finalsky.order.dao.system.OrderProductDao;
import com.finalsky.order.service.system.OrderProductService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.order.service.impl.system.OrderProductServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单商品表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@Service
public class OrderProductServiceImpl extends BaseServiceImpl<OrderProduct> implements OrderProductService {

    @Resource
    private OrderProductDao orderProductDao;

    @Override
    public List<OrderProduct> getOrderProductList(Map<String, Object> parameterMap) {
        return orderProductDao.queryForList(parameterMap);
    }
}
