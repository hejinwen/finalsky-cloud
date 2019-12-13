package com.finalsky.order.entity.system;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * com.finalsky.order.entity.system.OrderProduct.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单商品表实体类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "订单商品表实体类")
@Table(name = "sys_order_product")
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键ID
    */
    @ApiModelProperty(value = "主键ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
    * 订单ID
    */
    @ApiModelProperty(value = "订单ID")
    @Column(name = "order_id")
    private String orderId;

    /**
    * 订单ID
    */
    @ApiModelProperty(value = "订单ID")
    @Column(name = "product_id")
    private String productId;

    /**
    * 商品单价
    */
    @ApiModelProperty(value = "商品单价")
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
    * 商品数量
    */
    @ApiModelProperty(value = "商品数量")
    @Column(name = "product_count")
    private Integer productCount;

    /**
    * 商品总金额
    */
    @ApiModelProperty(value = "商品总金额")
    @Column(name = "product_amount")
    private Integer productAmount;

    /**
    * 备注
    */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
    * 数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时
    */
    @ApiModelProperty(value = "数据状态 枚举：-2临时保存 -1删除 0停用 1启用 2已过时")
    private Integer status;

    /**
    * 创建时间
    */
    @ApiModelProperty(value = "创建时间")
    @Column(name = "create_time")
    private Date createTime;

    /**
    * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    @Column(name = "modify_time")
    private Date modifyTime;


}
