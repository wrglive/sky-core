package com.marshall.sky.core.token;


import com.marshall.sky.core.enums.AuthEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckAuth {

  boolean isCheckToken() default true;

  AuthEnum authType() default AuthEnum.NONE;

}