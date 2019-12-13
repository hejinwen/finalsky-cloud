package com.finalsky.shoppingcart.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;

/**
 * com.finalsky.shoppingcart.model.ShoppingCartVO.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 购物车视图对象
 * @since : 2019-09-03 18:15
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "购物车视图对象")
public class ShoppingCartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 用户名称
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 商品ID
     */
    @ApiModelProperty(value = "商品ID")
    private String productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;

    /**
     * 商品数量
     */
    @ApiModelProperty(value = "商品数量")
    private Integer count;

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
