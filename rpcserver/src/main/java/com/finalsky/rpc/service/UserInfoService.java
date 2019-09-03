package com.finalsky.rpc.service;

import com.finalsky.rpc.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * com.finalsky.rpc.service.UserInfoService.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 用户服务Feign调用
 * @since : 2019-09-02 19:42
 */
@FeignClient(name = "user-service", fallback = UserInfoFallback.class, configuration = FeignConfiguration.class)
public interface UserInfoService {
    @RequestMapping(value = "/user-info/{id}", method = RequestMethod.GET)
    ResponseEntity<UserInfo> getUserInfo(@PathVariable String id);
}

class FeignConfiguration {
    @Bean
    public UserInfoFallback userInfoFallback() {
        return new UserInfoFallback();
    }
}

class UserInfoFallback implements UserInfoService {
    @Override
    public ResponseEntity<UserInfo> getUserInfo(String id) {
        return null;
    }
}
