package com.marshall.sky.core.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.marshall.sky.core.exception.SkyException;
import com.marshall.sky.core.exception.SkyExceptionEnum;
import com.marshall.sky.core.token.user.BaseUserMapper;
import com.marshall.sky.core.token.user.UserInfo;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

  @Autowired
  BaseUserMapper baseUserMapper;

  @Override
  public boolean preHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse, Object object) {
    String token = httpServletRequest.getHeader("access_token");// 从 http 请求头中取出 token
    // 如果不是映射到方法直接通过
    if (!(object instanceof HandlerMethod)) {
      return true;
    }
    HandlerMethod handlerMethod = (HandlerMethod) object;
    Method method = handlerMethod.getMethod();
    if (!method.isAnnotationPresent(CheckToken.class)) {
      return false;
    }
    CheckToken checkToken = method.getAnnotation(CheckToken.class);
    if (!checkToken.isChek()) {
      return true;
    }
    // 执行认证
    if (token == null) {
      throw new SkyException(SkyExceptionEnum.DONT_TOKEN);
    }
    // 获取 token 中的 user id
    long userId;
    try {
      userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
    } catch (JWTDecodeException j) {
      throw new SkyException(SkyExceptionEnum.EXCEPTION);
    }
    UserInfo user = baseUserMapper.getById(userId);
    if (user == null) {
      throw new SkyException(SkyExceptionEnum.USER_IS_EXIST);
    }
    // 验证 token
    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(String.valueOf(user.getCreateAt())))
        .build();
    try {
      jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
      throw new SkyException(SkyExceptionEnum.EXCEPTION);
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o, ModelAndView modelAndView) {

  }

  @Override
  public void afterCompletion(HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      Object o, Exception e) {
  }
}