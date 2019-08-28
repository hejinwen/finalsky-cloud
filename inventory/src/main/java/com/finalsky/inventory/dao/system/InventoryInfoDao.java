package com.finalsky.inventory.dao.system;

import com.finalsky.inventory.entity.system.InventoryInfo;
import info.joyc.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.inventory.dao.system.InventoryInfoDao.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品库存信息表数据访问类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 20:42
 */
public interface InventoryInfoDao extends BaseDao<InventoryInfo> {

    /**
     * 根据参数集合查询商品库存信息表列表
     *
     * @param parameterMap 参数集合
     * @return 商品库存信息表列表
     */
    List<InventoryInfo> queryForList(Map<String, Object> parameterMap);
}
