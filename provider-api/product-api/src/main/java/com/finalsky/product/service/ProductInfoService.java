package com.finalsky.product.service;

import com.finalsky.product.model.ProductInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * com.finalsky.product.service.ProductInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 商品信息操作接口
 * @since : 2019-09-03 20:57
 */
@FeignClient(value = "product-service")
public interface ProductInfoService {
    /**
     * 获取商品信息表列表
     * @param statusIds 数据状态集，逗号隔开
     * @param q 按code与name条件模糊匹配
     * @param pageNum 页码
     * @param pageSize 每页显示数据行数
     * @return
     */
    @GetMapping(value = "/product-info")
    ResponseEntity<PageInfo<ProductInfo>> getProductInfoList(@RequestParam(required = false) String statusIds,
                                                             @RequestParam(required = false) String q,
                                                             @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                             @RequestParam(required = false, defaultValue = "0") Integer pageSize);

    /**
     * 获取单个商品信息表详细信息
     * @param id 主键ID
     * @return
     */
    @GetMapping(value = "/product-info/{id}")
    ResponseEntity<ProductInfo> getProductInfo(@PathVariable String id);

    /**
     * 保存单个商品信息表
     * @param productInfo 商品信息表详细实体ProductInfo
     * @return
     */
    @PostMapping(value = "/product-info/save")
    ResponseEntity<ProductInfo> saveProductInfo(@RequestBody ProductInfo productInfo);

    /**
     * 批量删除商品信息表
     * @param ids 商品信息表IDs
     * @return
     */
    @PostMapping(value = "/product-info/delete")
    ResponseEntity<Integer> deleteProductInfo(@RequestParam List<String> ids);
}
