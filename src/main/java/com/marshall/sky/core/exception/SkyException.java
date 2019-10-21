package com.marshall.sky.core.exception;

public class SkyException extends RuntimeException {

    private String errorMsg;

    private String errorCode;

    private ExFactor exFactor;

    public SkyException(ExFactor exFactor) {
        super(exFactor.getModel().toString());
        this.exFactor = exFactor;
        this.errorMsg = exFactor.getModel().getErrorMsg();
        this.errorCode = exFactor.getModel().getErrorCode();
    }

    protected SkyException(SkyExceptionMsgModel skyExceptionMsgModel) {
        super(skyExceptionMsgModel.toString());
        this.errorMsg = skyExceptionMsgModel.getErrorMsg();
        this.errorCode = skyExceptionMsgModel.getErrorCode();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public ExFactor getExFactor() {
        return exFactor;
    }
}
