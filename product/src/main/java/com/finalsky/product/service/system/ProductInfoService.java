package com.finalsky.product.service.system;

import com.finalsky.product.entity.system.ProductInfo;
import info.joyc.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.product.service.system.ProductInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品信息表服务类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:26
 */
public interface ProductInfoService extends BaseService<ProductInfo> {

    /**
     * 根据Map条件查询ProductInfo对象列表
     *
     * @param parameterMap Map条件集合
     * @return ProductInfo对象列表
     */
    List<ProductInfo> getProductInfoList(Map<String, Object> parameterMap);
}
