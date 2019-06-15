package com.marshall.sky.core.exception;

public class SkyExceptionMsgModel {

  private int errorIndex;

  private String errorCode;

  private String errorMsg;

  private String httpCode;

  private String requestUri;

  public SkyExceptionMsgModel() {

  }

  public SkyExceptionMsgModel(int errorIndex, String errorCode, String errorMsg, String httpCode,
      String requestUri) {

    this.errorIndex = errorIndex;
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
    this.httpCode = httpCode;
    this.requestUri = requestUri;
  }

  public int getErrorIndex() {
    return errorIndex;
  }

  public void setErrorIndex(int errorIndex) {
    this.errorIndex = errorIndex;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getHttpCode() {
    return httpCode;
  }

  public void setHttpCode(String httpCode) {
    this.httpCode = httpCode;
  }

  public String getRequestUri() {
    return requestUri;
  }

  public void setRequestUri(String requestUri) {
    this.requestUri = requestUri;
  }

  @Override
  public String toString() {
    return "[" +
        "index=" + errorIndex +
        ", errorCode='" + errorCode + '\'' +
        ", errorMsg='" + errorMsg + '\'' +
        ']';
  }
}
