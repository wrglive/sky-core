package com.marshall.sky.core.logger.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void doBefore(JoinPoint point) {
        // AutoLogger annotation = methodSignature.getMethod().getAnnotation(AutoLogger.class);
        log.info(buildLogInfo(point).toString());
    }

    private StringBuilder buildLogInfo(JoinPoint point) {
        Class<?> clazz = point.getTarget().getClass();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Class[] parameterTypes = methodSignature.getParameterTypes();

        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("logInfo={method= ")
            .append(clazz.getName())
            .append(".")
            .append(methodSignature.getMethod().getName());
        logBuilder.append("(");

        for (int i = 0; i < parameterTypes.length; i++) {
            logBuilder.append(parameterTypes[i].getSimpleName());
            if (i < parameterTypes.length - 1) {
                logBuilder.append(", ");
            }
        }
        logBuilder.append("), ");

        logBuilder.append(" parameterMap={");
        for (int i = 0; i < parameterNames.length; i++) {
            logBuilder.append(parameterNames[i])
                .append(": ")
                .append(JSON.toJSONString(point.getArgs()[i]));
            if (i < parameterNames.length - 1) {
                logBuilder.append(", ");
            }
        }
        logBuilder.append("}} ");
        return logBuilder;
    }

}
