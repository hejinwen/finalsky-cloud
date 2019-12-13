package com.finalsky.order.web.system;

import com.github.pagehelper.PageInfo;
import com.finalsky.order.entity.system.OrderProduct;
import com.finalsky.order.service.system.OrderProductService;
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
 * com.finalsky.order.web.system.OrderProductController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单商品表控制类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@RestController
@Api(value = "订单商品表Controller", description = "订单商品表相关api", tags = {"订单商品表操作接口"})
@RequestMapping("/order-product")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @ApiOperation(value = "获取订单商品表列表", notes = "获取订单商品表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "statusIds", value = "数据状态集，逗号隔开", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据行数", required = false, dataType = "int")
    })
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<OrderProduct>> getOrderProductList(@RequestParam(required = false) String statusIds,
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
        return ResponseEntity.ok(new PageInfo<>(orderProductService.getOrderProductList(parameterMap)));
    }

    @ApiOperation(value = "获取单个订单商品表详细信息", notes = "根据url的id来获取订单商品表详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderProduct> getOrderProduct(@PathVariable String id) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(id);
        return ResponseEntity.ok(orderProductService.find(orderProduct));
    }

    @ApiOperation(value = "保存单个订单商品表", notes = "根据OrderProduct对象保存订单商品表")
    @ApiImplicitParam(paramType = "body", name = "orderProduct", value = "订单商品表详细实体OrderProduct", required = true, dataType = "OrderProduct")
    @PostMapping(value = "/save")
    public ResponseEntity<OrderProduct> saveOrderProduct(@RequestBody OrderProduct orderProduct) {
        Assert.notNull(orderProduct, "保存的对象不能为空!");
        Assert.notNull(orderProduct.getStatus(), "保存的对象数据状态不能为空!");
        return new ResponseEntity<>(orderProductService.save(orderProduct), HttpStatus.CREATED);
    }

    @ApiOperation(value = "批量删除订单商品表", notes = "根据url的ids来指定删除对象")
    @ApiImplicitParam(paramType = "form", name = "ids", value = "订单商品表IDs", required = true, allowMultiple = true, dataType = "string")
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> deleteOrderProduct(@RequestParam List<String> ids) {
        int deleteCount = orderProductService.deleteBatchByIds(ids);
        Assert.state(deleteCount != 0, "无此ID对应的数据对象！");
        return new ResponseEntity<>(deleteCount, HttpStatus.NO_CONTENT);
    }
}
