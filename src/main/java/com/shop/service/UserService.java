package com.shop.service;

import com.shop.service.model.UserModel;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 22:10
 */
public interface UserService {
    //通过用户Id获取用户信息的方法
    UserModel getUserById(Integer id);
}
