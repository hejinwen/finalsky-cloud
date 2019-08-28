package com.finalsky.user.web.system;

import com.github.pagehelper.PageInfo;
import com.finalsky.user.entity.system.UserInfo;
import com.finalsky.user.service.system.UserInfoService;
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
 * com.finalsky.user.web.system.UserInfoController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.finalsky.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @desc : 用户信息表控制类
 * @author : hejw
 * @version : v1.0.0
 * @since : 2019-08-22 11:32
 */
@RestController
@Api(value = "用户信息表Controller", description = "用户信息表相关api", tags = {"用户信息表操作接口"})
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "获取用户信息表列表", notes = "获取用户信息表列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "statusIds", value = "数据状态集，逗号隔开", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "q", value = "按code与name条件模糊匹配", required = false, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页码", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示数据行数", required = false, dataType = "int")
    })
    @GetMapping(value = "")
    public ResponseEntity<PageInfo<UserInfo>> getUserInfoList(@RequestParam(required = false) String statusIds,
                                                                @RequestParam(required = false) String q,
                                                                @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                                @RequestParam(required = false, defaultValue = "0") Integer pageSize) {
        Map<String, Object> parameterMap = new HashMap<>();
        if (StringUtil.isNotBlank(statusIds)) {
            parameterMap.put("statusIds", Arrays.asList(statusIds.split(",")));
        } else {
            parameterMap.put("status", DataStatusEnum.Enabled.getIndex());
        }
        if (StringUtil.isNotBlank(q)) {
            parameterMap.put("q", q);
        }
        parameterMap.put("pageNum", pageNum);
        parameterMap.put("pageSize", pageSize);
        return ResponseEntity.ok(new PageInfo<>(userInfoService.getUserInfoList(parameterMap)));
    }

    @ApiOperation(value = "获取单个用户信息表详细信息", notes = "根据url的id来获取用户信息表详细信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "string")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable String id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        return ResponseEntity.ok(userInfoService.find(userInfo));
    }

    @ApiOperation(value = "保存单个用户信息表", notes = "根据UserInfo对象保存用户信息表")
    @ApiImplicitParam(paramType = "body", name = "userInfo", value = "用户信息表详细实体UserInfo", required = true, dataType = "UserInfo")
    @PostMapping(value = "/save")
    public ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo) {
        Assert.notNull(userInfo, "保存的对象不能为空!");
        Assert.notNull(userInfo.getStatus(), "保存的对象数据状态不能为空!");
        return new ResponseEntity<>(userInfoService.save(userInfo), HttpStatus.CREATED);
    }

    @ApiOperation(value = "批量删除用户信息表", notes = "根据url的ids来指定删除对象")
    @ApiImplicitParam(paramType = "form", name = "ids", value = "用户信息表IDs", required = true, allowMultiple = true, dataType = "string")
    @PostMapping(value = "/delete")
    public ResponseEntity<Integer> deleteUserInfo(@RequestParam List<String> ids) {
        int deleteCount = userInfoService.deleteBatchByIds(ids);
        Assert.state(deleteCount != 0, "无此ID对应的数据对象！");
        return new ResponseEntity<>(deleteCount, HttpStatus.NO_CONTENT);
    }
}
