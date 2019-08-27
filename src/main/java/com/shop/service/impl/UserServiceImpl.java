package com.shop.service.impl;

import com.shop.dao.UserInfoMapper;
import com.shop.dao.UserPasswordMapper;
import com.shop.pojo.UserInfo;
import com.shop.pojo.UserPassword;
import com.shop.service.UserService;
import com.shop.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 22:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private UserPasswordMapper userPasswordMapper;

    @Override
    public UserModel getUserById(Integer id) {

        //调用userInfoMapper获取到对应的用户pojo
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        if(userInfo == null){
            return null;
        }

        UserPassword userPassword = userPasswordMapper.selectByUserId(userInfo.getId());
        return convertFromPojo(userInfo,userPassword);
    }


    private UserModel convertFromPojo(UserInfo userInfo, UserPassword userPassword) {

        if(userInfo == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfo,userModel);

        if(userPassword != null ){
            userModel.setEncrptPassword(userPassword.getEncrptPassword());
        }

        return userModel;
    }
}
