package com.shop.controller;

import com.shop.error.BussinessErrorEnum;
import com.shop.error.BussinessException;
import com.shop.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-29 01:11
 */
public class BaseController {

    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseMap = new HashMap<>();
        if (ex instanceof BussinessException) {
            BussinessException bussinessException = (BussinessException) ex;

            responseMap.put("errCode", bussinessException.getErrorCode());
            responseMap.put("errMsg", bussinessException.getErrMsg());
        } else {
            responseMap.put("errCode", BussinessErrorEnum.UNKNOWN_ERROR.getErrorCode());
            responseMap.put("errMsg", BussinessErrorEnum.UNKNOWN_ERROR.getErrMsg());
        }


        return CommonReturnType.create(responseMap, "fail");
    }
}
