package com.finalsky.user.service;

import com.finalsky.user.entity.system.UserInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * com.finalsky.user.service.UserInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 用户信息操作接口
 * @since : 2019-08-31 18:10
 */
@FeignClient(value = "user-service")
public interface UserInfoService {
    /**
     * 获取用户信息表列表
     * @param statusIds 数据状态集，逗号隔开
     * @param q 按code与name条件模糊匹配
     * @param pageNum 页码
     * @param pageSize 每页显示数据行数
     * @return
     */
    @GetMapping(value = "/user-info")
    ResponseEntity<PageInfo<UserInfo>> getUserInfoList(@RequestParam(required = false) String statusIds,
                                                       @RequestParam(required = false) String q,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageSize);

    /**
     * 获取单个用户信息表详细信息
     * @param id 主键ID
     * @return
     */
    @GetMapping(value = "/user-info/{id}")
    ResponseEntity<UserInfo> getUserInfo(@PathVariable String id);

    /**
     * 保存单个用户信息表
     * @param userInfo 用户信息表详细实体UserInfo
     * @return
     */
    @PostMapping(value = "/user-info/save")
    ResponseEntity<UserInfo> saveUserInfo(@RequestBody UserInfo userInfo);

    /**
     * 批量删除用户信息表
     * @param ids 用户信息表IDs
     * @return
     */
    @PostMapping(value = "/user-info/delete")
    ResponseEntity<Integer> deleteUserInfo(@RequestParam List<String> ids);
}
