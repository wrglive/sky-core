package com.marshall.sky.core.exception;

public enum SkyExceptionEnum implements ExFactor {
  EXCEPTION(1, "default error", "默认异常"),
  USER_IS_NOT_EXIST(2, "user is not exist", "用户不存在鸭。"),
  DONT_TOKEN(3, "dont token", "token为必填项。"),
  NEED_CHECK_AUTH_INTERFACE(4, "you need @checkAuth interface", "@checkAuth 为必填项"),
  TOKEN_VERIFY_ERROR(5, "token verify error", "token校验错误。"),
  AUTH_ERROR(6, "auth error", "权限校验失败, 请申请权限后重新登录。"),
  ;

  int errorIndex;
  String errorCode;
  String errorMsg;

  SkyExceptionEnum(int errorIndex, String errorCode, String errorMsg) {
    this.errorIndex = errorIndex;
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public int getErrorIndex() {
    return errorIndex;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }


  @Override
  public SkyExceptionMsgModel getModel() {
    return new SkyExceptionMsgModel(errorIndex, errorCode, errorMsg, "", "");
  }


}
