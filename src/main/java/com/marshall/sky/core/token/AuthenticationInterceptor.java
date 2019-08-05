package com.marshall.sky.core.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.marshall.sky.core.enums.RoleEnum;
import com.marshall.sky.core.exception.SkyException;
import com.marshall.sky.core.exception.SkyExceptionEnum;
import com.marshall.sky.core.token.user.UserAuthMapper;
import com.marshall.sky.core.token.user.UserInfo;
import com.marshall.sky.core.token.user.UserRole;
import java.lang.reflect.Method;
import java.util.Comparator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

  @Autowired
  UserAuthMapper userAuthMapper;

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
    checkAuth(token, method, httpServletRequest);
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

  private void checkAuth(String token, Method method, HttpServletRequest httpServletRequest) {
    if (!method.isAnnotationPresent(CheckAuth.class)) {
      throw new SkyException(SkyExceptionEnum.NEED_CHECK_AUTH_INTERFACE);
    }
    CheckAuth checkAuth = method.getAnnotation(CheckAuth.class);
    //不校验token的是公开接口就没有必要鉴权直接访问, 当他为false 不会执行 roleType,
    //如果你false 还传 token 我就会鉴定你的 token 违规会抛异常, 不传为0;
    //为true 必须鉴定token 还有权限。
    long userId;
    if (!checkAuth.isCheckToken()) {
      userId = StringUtils.isBlank(token) ? 0L : checkToken(token);
      httpServletRequest.setAttribute("from_user_id", userId);
      return;
    }
    userId = checkToken(token);
    httpServletRequest.setAttribute("from_user_id", userId);
    checkPermission(userId, checkAuth.roleType());
  }

  /**
   * 鉴权取数据
   */
  private long checkToken(String token) {
    // 执行认证
    if (StringUtils.isBlank(token)) {
      throw new SkyException(SkyExceptionEnum.DONT_TOKEN);
    }
    // 获取 token 中的 user id
    long userId;
    try {
      userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
    } catch (JWTDecodeException j) {
      throw new SkyException(SkyExceptionEnum.TOKEN_VERIFY_ERROR);
    }
    UserInfo user = userAuthMapper.getById(userId);
    if (user == null) {
      throw new SkyException(SkyExceptionEnum.USER_IS_NOT_EXIST);
    }
    // 验证 token
    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(String.valueOf(user.getCreateAt())))
        .build();
    try {
      jwtVerifier.verify(token);
    } catch (JWTVerificationException e) {
      throw new SkyException(SkyExceptionEnum.TOKEN_VERIFY_ERROR);
    }
    return userId;
  }

  private void checkPermission(long userId, RoleEnum methodRoleType) {
    RoleEnum userMaxRole = userAuthMapper.listUserRoleByUserId(userId).stream()
        .sorted(Comparator.comparingInt(user -> user.getRoleType().getIndex()))
        .findFirst()
        .map(UserRole::getRoleType)
        .orElse(RoleEnum.NONE);
    int userRoleScore = userMaxRole.getIndex();
    int methodRoleScore =
        methodRoleType == null ? RoleEnum.NONE.getIndex() : methodRoleType.getIndex();

    if (userRoleScore < methodRoleScore) {
      throw new SkyException(SkyExceptionEnum.AUTH_ERROR);
    }
  }

}