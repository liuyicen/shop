package com.shop;

import com.shop.dao.UserInfoMapper;
import com.shop.pojo.UserInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages ={"com.shop"})
@RestController
@MapperScan("com.shop.dao")
public class App {

    @Resource
    private UserInfoMapper userInfoMapper;
    @RequestMapping("/")
    public String home()
    {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(1);
        if(userInfo == null){
            return "用户对象不存在";
        }else{
            return userInfo.getName();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(App.class,args);
    }


}
