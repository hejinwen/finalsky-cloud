package com.finalsky.shoppingcart.web.system;

import com.github.pagehelper.PageInfo;
import com.finalsky.shoppingcart.entity.system.ShoppingCart;
import com.finalsky.shoppingcart.service.system.ShoppingCartService;
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
 * com.finalsky.shoppingcart.web.system.ShoppingCartController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 购物车表控制类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-26 16:38
 */
@RestController
@Api(value = "购物车表Controller", description = "购物车表相关api", tags = {"购物车表操作接口"})
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation(value = "获取购物车表列表", notes = "获取购物车表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "statusIds", value = "数据状态集，逗号隔开", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据行数", required = false, dataType = "int")
    })
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<ShoppingCart>> getShoppingCartList(@RequestParam(required = false) String statusIds,
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
        return ResponseEntity.ok(new PageInfo<>(shoppingCartService.getShoppingCartList(parameterMap)));
    }

    @ApiOperation(value = "获取单个购物车表详细信息", notes = "根据url的id来获取购物车表详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable String id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(id);
        return ResponseEntity.ok(shoppingCartService.find(shoppingCart));
    }

    @ApiOperation(value = "保存单个购物车表", notes = "根据ShoppingCart对象保存购物车表")
    @ApiImplicitParam(paramType = "body", name = "shoppingCart", value = "购物车表详细实体ShoppingCart", required = true, dataType = "ShoppingCart")
    @PostMapping(value = "/save")
    public ResponseEntity<ShoppingCart> saveShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        Assert.notNull(shoppingCart, "保存的对象不能为空!");
        Assert.notNull(shoppingCart.getStatus(), "保存的对象数据状态不能为空!");
        return new ResponseEntity<>(shoppingCartService.save(shoppingCart), HttpStatus.CREATED);
    }

    @ApiOperation(value = "批量删除购物车表", notes = "根据url的ids来指定删除对象")
    @ApiImplicitParam(paramType = "form", name = "ids", value = "购物车表IDs", required = true, allowMultiple = true, dataType = "string")
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> deleteShoppingCart(@RequestParam List<String> ids) {
        int deleteCount = shoppingCartService.deleteBatchByIds(ids);
        Assert.state(deleteCount != 0, "无此ID对应的数据对象！");
        return new ResponseEntity<>(deleteCount, HttpStatus.NO_CONTENT);
    }
}
