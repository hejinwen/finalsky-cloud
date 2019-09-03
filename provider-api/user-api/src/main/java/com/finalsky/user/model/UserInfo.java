package com.finalsky.user.model;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * com.finalsky.user.model.UserInfo.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 用户信息
 * @since : 2019-08-31 15:25
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "用户信息")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 人员ID
     */
    @ApiModelProperty(value = "人员ID")
    private String id;

    /**
     * 人员名称
     */
    @ApiModelProperty(value = "人员名称")
    private String name;

    /**
     * 性别：0-男;1-女;
     */
    @ApiModelProperty(value = "性别：0-男;1-女;")
    private Integer sex;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String idCard;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 住址
     */
    @ApiModelProperty(value = "住址")
    private String address;

    /**
     * 是否登陆
     */
    @ApiModelProperty(value = "是否登陆")
    private Integer loginable;

    /**
     * 登陆名
     */
    @ApiModelProperty(value = "登陆名")
    private String loginName;

    /**
     * 登陆密码
     */
    @ApiModelProperty(value = "登陆密码")
    private String loginPassword;

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

