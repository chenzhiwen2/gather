package com.gather.util;

public class BaseException extends RuntimeException {

    protected int code;

    protected String message;

    public BaseException() {
        super();
    }

    public BaseException(int code) {
        super();
        this.code = code;
    }

    public BaseException(ExceptionEnum exceptionEnum) {
        super();
        if (null != exceptionEnum) {
            this.code = exceptionEnum.getCode();
            this.message = exceptionEnum.getMessage();
        }
    }

    public BaseException(int code, String message) {
        super();
        this.code = code;
        if (null != message) {
            this.message = message;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}