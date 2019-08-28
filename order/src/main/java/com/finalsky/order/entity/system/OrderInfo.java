package com.finalsky.order.entity.system;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * com.finalsky.order.entity.system.OrderInfo.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 订单信息表实体类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:29
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "订单信息表实体类")
@Table(name = "sys_order_info")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 订单ID
    */
    @ApiModelProperty(value = "订单ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID")
    @Column(name = "user_id")
    private String userId;

    /**
    * 订单号
    */
    @ApiModelProperty(value = "订单号")
    @Column(name = "order_number")
    private String orderNumber;

    /**
    * 订单状态
    */
    @ApiModelProperty(value = "订单状态")
    @Column(name = "order_amount")
    private Integer orderAmount;

    /**
    * 下单时间
    */
    @ApiModelProperty(value = "下单时间")
    @Column(name = "order_date")
    private Date orderDate;

    /**
    * 订单状态
    */
    @ApiModelProperty(value = "订单状态")
    @Column(name = "order_status")
    private Integer orderStatus;

    /**
    * 收货人姓名
    */
    @ApiModelProperty(value = "收货人姓名")
    @Column(name = "receive_name")
    private String receiveName;

    /**
    * 收货人地址
    */
    @ApiModelProperty(value = "收货人地址")
    @Column(name = "receive_address")
    private String receiveAddress;

    /**
    * 收货人电话
    */
    @ApiModelProperty(value = "收货人电话")
    @Column(name = "receive_phone")
    private String receivePhone;

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
