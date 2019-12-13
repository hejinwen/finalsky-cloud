package com.finalsky.inventory.entity.system;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * com.finalsky.inventory.entity.system.InventoryInfo.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 商品库存信息表实体类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-27 20:42
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "商品库存信息表实体类")
@Table(name = "sys_inventory_info")
public class InventoryInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键ID
    */
    @ApiModelProperty(value = "主键ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
    * 商品ID
    */
    @ApiModelProperty(value = "商品ID")
    @Column(name = "product_id")
    private String productId;

    /**
    * 库存数量
    */
    @ApiModelProperty(value = "库存数量")
    @Column(name = "inventory_count")
    private Integer inventoryCount;

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
