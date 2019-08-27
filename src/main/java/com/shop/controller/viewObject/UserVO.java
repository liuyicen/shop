package com.shop.controller.viewObject;

import lombok.Data;

/**
 * 用于返回前端展示的领域模型对象
 *
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 23:22
 */
@Data
public class UserVO {

    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telphone;
}
