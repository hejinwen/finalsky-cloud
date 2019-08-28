package com.finalsky.product.dao.system;

import com.finalsky.product.entity.system.ProductInfo;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.product.dao.system.ProductInfoDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品信息表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:26
 */
public interface ProductInfoDao extends BaseDao<ProductInfo> {

    /**
     * 根据参数集合查询商品信息表列表
     *
     * @param parameterMap 参数集合
     * @return 商品信息表列表
     */
    List<ProductInfo> queryForList(Map<String, Object> parameterMap);
}
