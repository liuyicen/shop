package com.shop.response;

import lombok.Data;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 23:37
 */
@Data
public class CommonReturnType {

    //对应请求的返回处理结果，"success"或"fail"
    private String status;
    //若status为success则data返回前端所需要的json格式
    //若status为fail，则data内使用的通用的错误吗格式
    private Object data;

    //定义一个通用的创建方法
    public static  CommonReturnType create(Object result) {
        return CommonReturnType.create(result,"success");
    }

    public static  CommonReturnType create(Object result,String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setStatus(status);
        commonReturnType.setData(result);
        return commonReturnType;
    }
}
