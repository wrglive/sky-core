package com.marshall.sky.core.token;


import com.marshall.sky.core.enums.RoleEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {

  boolean isCheckToken() default true;

  RoleEnum roleType() default RoleEnum.NONE;

}