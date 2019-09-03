package com.finalsky.rpc.web;

import com.finalsky.rpc.model.UserInfo;
import com.finalsky.rpc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * com.finalsky.rpc.web.TestController.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 远程服务调用测试
 * @since : 2019-09-02 19:23
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping(value = "/rest/{id}")
    public String rest(@PathVariable String id) {
        return restTemplate.getForObject("http://user-service/user-info/" + id, String.class);
    }

    @GetMapping(value = "/feign/{id}")
    public ResponseEntity<UserInfo> feign(@PathVariable String id) {
        return userInfoService.getUserInfo(id);
    }

    @GetMapping(value = "/services/{service}")
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @GetMapping(value = "/services")
    public Object services() {
        return discoveryClient.getServices();
    }

}
