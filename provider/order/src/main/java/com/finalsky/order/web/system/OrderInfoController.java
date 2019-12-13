package com.finalsky.order.web.system;

import com.github.pagehelper.PageInfo;
import com.finalsky.order.entity.system.OrderInfo;
import com.finalsky.order.service.system.OrderInfoService;
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
 * com.finalsky.order.web.system.OrderInfoController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单信息表控制类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@RestController
@Api(value = "订单信息表Controller", description = "订单信息表相关api", tags = {"订单信息表操作接口"})
@RequestMapping("/order-info")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value = "获取订单信息表列表", notes = "获取订单信息表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "statusIds", value = "数据状态集，逗号隔开", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据行数", required = false, dataType = "int")
    })
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<OrderInfo>> getOrderInfoList(@RequestParam(required = false) String statusIds,
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
        return ResponseEntity.ok(new PageInfo<>(orderInfoService.getOrderInfoList(parameterMap)));
    }

    @ApiOperation(value = "获取单个订单信息表详细信息", notes = "根据url的id来获取订单信息表详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderInfo> getOrderInfo(@PathVariable String id) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(id);
        return ResponseEntity.ok(orderInfoService.find(orderInfo));
    }

    @ApiOperation(value = "保存单个订单信息表", notes = "根据OrderInfo对象保存订单信息表")
    @ApiImplicitParam(paramType = "body", name = "orderInfo", value = "订单信息表详细实体OrderInfo", required = true, dataType = "OrderInfo")
    @PostMapping(value = "/save")
    public ResponseEntity<OrderInfo> saveOrderInfo(@RequestBody OrderInfo orderInfo) {
        Assert.notNull(orderInfo, "保存的对象不能为空!");
        Assert.notNull(orderInfo.getStatus(), "保存的对象数据状态不能为空!");
        return new ResponseEntity<>(orderInfoService.save(orderInfo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "批量删除订单信息表", notes = "根据url的ids来指定删除对象")
    @ApiImplicitParam(paramType = "form", name = "ids", value = "订单信息表IDs", required = true, allowMultiple = true, dataType = "string")
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> deleteOrderInfo(@RequestParam List<String> ids) {
        int deleteCount = orderInfoService.deleteBatchByIds(ids);
        Assert.state(deleteCount != 0, "无此ID对应的数据对象！");
        return new ResponseEntity<>(deleteCount, HttpStatus.NO_CONTENT);
    }
}
