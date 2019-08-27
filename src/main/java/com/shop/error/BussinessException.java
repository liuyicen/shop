package com.shop.error;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-29 00:40
 */

//包装器业务异常实现
public class BussinessException extends Exception implements CommonError {

    private CommonError commonError;

    //直接接收BussinessErrorEnum的传参用于构造业务异常
    public BussinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    //接收自定义errMsg的方式构造业务异常
    public BussinessException(CommonError commonError,String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public Integer getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
