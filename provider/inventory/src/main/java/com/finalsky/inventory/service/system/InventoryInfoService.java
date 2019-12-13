package com.finalsky.inventory.service.system;

import com.finalsky.inventory.entity.system.InventoryInfo;
import info.joyc.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * com.finalsky.inventory.service.system.InventoryInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品库存信息表服务类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 20:42
 */
public interface InventoryInfoService extends BaseService<InventoryInfo> {

    /**
     * 根据Map条件查询InventoryInfo对象列表
     *
     * @param parameterMap Map条件集合
     * @return InventoryInfo对象列表
     */
    List<InventoryInfo> getInventoryInfoList(Map<String, Object> parameterMap);
}
