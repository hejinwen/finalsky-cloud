package com.finalsky.inventory.web.system;

import com.github.pagehelper.PageInfo;
import com.finalsky.inventory.entity.system.InventoryInfo;
import com.finalsky.inventory.service.system.InventoryInfoService;
import info.joyc.core.enums.DataStatusEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import info.joyc.tool.lang.Assert;
import info.joyc.tool.util.StringUtil;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.finalsky.inventory.web.system.InventoryInfoController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品库存信息表控制类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 20:42
 */
@RestController
@Api(value = "商品库存信息表Controller", description = "商品库存信息表相关api", tags = {"商品库存信息表操作接口"})
@RequestMapping("/inventory-info")
public class InventoryInfoController {

    @Autowired
    private InventoryInfoService inventoryInfoService;

    @ApiOperation(value = "获取商品库存信息表列表", notes = "获取商品库存信息表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "statusIds", value = "数据状态集，逗号隔开", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据行数", required = false, dataType = "int")
    })
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<InventoryInfo>> getInventoryInfoList(@RequestParam(required = false) String statusIds,
                                                                @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                                @RequestParam(required = false, defaultValue = "0") Integer pageSize) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtil.isNotBlank(statusIds)) {
            parameterMap.put("statusIds", Arrays.asList(statusIds.split(",")));
        } else {
            parameterMap.put("status", DataStatusEnum.Enabled.getIndex());
        }
        parameterMap.put("pageNum", pageNum);
        parameterMap.put("pageSize", pageSize);
        return ResponseEntity.ok(new PageInfo<>(inventoryInfoService.getInventoryInfoList(parameterMap)));
    }

    @ApiOperation(value = "获取单个商品库存信息表详细信息", notes = "根据url的id来获取商品库存信息表详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResponseEntity<InventoryInfo> getInventoryInfo(@PathVariable String id) {
        InventoryInfo inventoryInfo = new InventoryInfo();
        inventoryInfo.setId(id);
        return ResponseEntity.ok(inventoryInfoService.find(inventoryInfo));
    }

    @ApiOperation(value = "保存单个商品库存信息表", notes = "根据InventoryInfo对象保存商品库存信息表")
    @ApiImplicitParam(paramType = "body", name = "inventoryInfo", value = "商品库存信息表详细实体InventoryInfo", required = true, dataType = "InventoryInfo")
    @PostMapping(value = "/save")
    public ResponseEntity<InventoryInfo> saveInventoryInfo(@RequestBody InventoryInfo inventoryInfo) {
        Assert.notNull(inventoryInfo, "保存的对象不能为空!");
        Assert.notNull(inventoryInfo.getStatus(), "保存的对象数据状态不能为空!");
        return new ResponseEntity<>(inventoryInfoService.save(inventoryInfo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "批量删除商品库存信息表", notes = "根据url的ids来指定删除对象")
    @ApiImplicitParam(paramType = "form", name = "ids", value = "商品库存信息表IDs", required = true, allowMultiple = true, dataType = "string")
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> deleteInventoryInfo(@RequestParam List<String> ids) {
        int deleteCount = inventoryInfoService.deleteBatchByIds(ids);
        Assert.state(deleteCount != 0, "无此ID对应的数据对象！");
        return new ResponseEntity<>(deleteCount, HttpStatus.NO_CONTENT);
    }
}
