package com.finalsky.product.service.impl.system;

import com.finalsky.product.entity.system.ProductInfo;
import com.finalsky.product.dao.system.ProductInfoDao;
import com.finalsky.product.service.system.ProductInfoService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.product.service.impl.system.ProductInfoServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品信息表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:26
 */
@Service
public class ProductInfoServiceImpl extends BaseServiceImpl<ProductInfo> implements ProductInfoService {

    @Resource
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> getProductInfoList(Map<String, Object> parameterMap) {
        return productInfoDao.queryForList(parameterMap);
    }
}
