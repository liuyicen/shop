package com.shop.service.model;

import lombok.Data;

/**
 * 后端用于自己业务处理的领域模型
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 22:18
 */
@Data
public class UserModel {

    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telphone;
    private String registerMode;



    private String encrptPassword;
}
