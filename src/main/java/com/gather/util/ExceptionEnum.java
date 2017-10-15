package com.gather.util;


public interface ExceptionEnum {

    /**
     * 获取异常代码
     *
     * @return 异常代码
     */
    int getCode();

    /**
     * 获取异常信息
     *
     * @return 异常信息
     */
    String getMessage();

    /**
     * 获取异常提示
     *
     * @return 异常提示
     */
    String getPrompt();

}

