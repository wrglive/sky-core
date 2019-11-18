package com.marshall.sky.core.logger.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 *
 * @author wangruigang
 */
@Component
@Aspect
@Slf4j
public class LoggerAspect {


    @Pointcut(value = "@annotation(com.marshall.sky.core.logger.annotation.AutoLogger)")
    public void execute() {
    }

    /**
     * 对带注解@OpLog的方法进行切面，并获取到注解的属性值
     */
    @Before(value = "execute()")
    public void permissionCheck(JoinPoint point) {
        Class<?> clazz = point.getTarget().getClass();
        Class<?> thisClass = point.getThis().getClass();
        log.info("thisClassName={}, targetClassName={}, method={}, args={}", thisClass.getSimpleName(), clazz.getSimpleName(),
            point.getSignature().getName(), point.getArgs());
    }

}
