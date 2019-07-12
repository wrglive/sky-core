package com.marshall.sky.core.exception;

public enum SkyExceptionEnum implements ExFactor {
  EXCEPTION(1, "default error", "默认异常"),
  USER_IS_EXIST(2, "user is exist", "用户不存在鸭。"),
  DONT_TOKEN(3, "dont token", "token is exist。"),
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
