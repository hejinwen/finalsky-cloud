package com.finalsky.user.aop;

import info.joyc.core.aop.BaseWebLogAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * com.finalsky.user.aop.WebLogAspect.java
 * ==============================================
 * Copy right 2015-2019 by http://www.rejoysoft.com
 * ----------------------------------------------
 * This is not a free software, without any authorization is not allowed to use and spread.
 * ==============================================
 *
 * @author : hejw
 * @version : v1.0.0
 * @desc : 使用AOP统一处理Web请求日志
 * @since : 2019-08-26 22:37
 */
@Aspect
@Component
public class WebLogAspect extends BaseWebLogAspect {
    @Pointcut("execution(public * com.finalsky.user.web..*.*(..))")
    @Override
    public void webLog() {
    }
}
