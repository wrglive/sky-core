package com.marshall.sky.core.logger.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动日志
 * exp:  logInfo={method= com.marshall.sky.pet.controller.PetVarietyController.list(long, ServiceHeaderEntity, int, int),
 *       parameterMap={fromUserId: 0, headerEntity: {"logId":1574151796846000,"userId":0}, page: 0, count: 20}}
 *
 * @author wangruigang
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoLogger {

}
