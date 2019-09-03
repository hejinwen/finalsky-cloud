package com.finalsky.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * com.finalsky.product.model.ProductInfo.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品信息模型
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-09-03 20:58
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "商品信息表实体类")
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 商品ID
    */
    @ApiModelProperty(value = "商品ID")
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
    private Date createTime;

    /**
    * 修改时间
    */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

}
