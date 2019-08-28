package com.finalsky.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * com.finalsky.user.config.Swagger2Config.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : Swagger2配置类
 * @since : 2019-08-26 19:02
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private ApiInfo systemApiInfo() {
        return new ApiInfoBuilder()
                .title("RESTful Api文档")
                .description("分布式系统架构---用户服务---系统管理")
                .version("1.0")
                .contact(new Contact("finalsky-cloud", "https://github.com/hejinwen/finalsky-cloud", "342992153@qq.com"))
                .build();
    }

    @Bean
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("00-system")
                .apiInfo(systemApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.finalsky.user.web.system"))
                .paths(PathSelectors.any())
                .build();
    }

}
