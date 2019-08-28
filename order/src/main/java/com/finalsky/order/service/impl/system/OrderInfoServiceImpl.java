package com.finalsky.order.service.impl.system;

import com.finalsky.order.entity.system.OrderInfo;
import com.finalsky.order.dao.system.OrderInfoDao;
import com.finalsky.order.service.system.OrderInfoService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.order.service.impl.system.OrderInfoServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单信息表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@Service
public class OrderInfoServiceImpl extends BaseServiceImpl<OrderInfo> implements OrderInfoService {

    @Resource
    private OrderInfoDao orderInfoDao;

    @Override
    public List<OrderInfo> getOrderInfoList(Map<String, Object> parameterMap) {
        return orderInfoDao.queryForList(parameterMap);
    }
}
