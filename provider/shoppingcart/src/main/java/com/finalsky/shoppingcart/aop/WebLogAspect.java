package com.finalsky.shoppingcart.aop;

import info.joyc.core.aop.BaseWebLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * com.finalsky.shoppingcart.aop.WebLogAspect.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 使用AOP统一处理Web请求日志
 * @since : 2019-08-26 22:53
 */
@Aspect
@Component
public class WebLogAspect extends BaseWebLogAspect {
    @Pointcut("execution(public * com.finalsky.shoppingcart.web..*.*(..))")
    @Override
    public void webLog() {
    }
}
