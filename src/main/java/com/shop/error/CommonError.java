package com.shop.error;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-29 00:27
 */
public interface CommonError {

    Integer getErrorCode();

    String getErrMsg();

    CommonError setErrMsg(String errMsg);
}
