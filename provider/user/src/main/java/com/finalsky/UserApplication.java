package com.finalsky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * com.finalsky.user.UserApplication.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 用户服务
 * @since : 2019-08-21 19:42
 */
@SpringBootApplication
@MapperScan(basePackages = "com.finalsky.user.dao")
@EnableDiscoveryClient
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
