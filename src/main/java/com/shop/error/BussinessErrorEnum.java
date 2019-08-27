package com.shop.error;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-29 00:31
 */
public enum BussinessErrorEnum implements CommonError {
    //通用错误类型10001
    PARAMTER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),


    //20000开头为用户信息相关错误定义
    USER_NOT_EXIST(20001,"用户不存在")
    ;

    private Integer errCode;
    private String errMsg;

    BussinessErrorEnum(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public Integer getErrorCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
