package com.finalsky.inventory.service.impl.system;

import com.finalsky.inventory.entity.system.InventoryInfo;
import com.finalsky.inventory.dao.system.InventoryInfoDao;
import com.finalsky.inventory.service.system.InventoryInfoService;
import info.joyc.core.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.inventory.service.impl.system.InventoryInfoServiceImpl.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品库存信息表服务实现类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 20:42
 */
@Service
public class InventoryInfoServiceImpl extends BaseServiceImpl<InventoryInfo> implements InventoryInfoService {

    @Resource
    private InventoryInfoDao inventoryInfoDao;

    @Override
    public List<InventoryInfo> getInventoryInfoList(Map<String, Object> parameterMap) {
        return inventoryInfoDao.queryForList(parameterMap);
    }
}
