package com.finalsky.product.entity.system;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * com.finalsky.product.entity.system.ProductInfo.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品信息表实体类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 17:26
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "商品信息表实体类")
@Table(name = "sys_product_info")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 商品ID
    */
    @ApiModelProperty(value = "商品ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
    * 商品编码
    */
    @ApiModelProperty(value = "商品编码")
    private String code;

    /**
    * 商品名称
    */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
    * 单价
    */
    @ApiModelProperty(value = "单价")
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    /**
    * 商品图片
    */
    @ApiModelProperty(value = "商品图片")
    private String picture;

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
