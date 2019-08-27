package com.shop.controller;

import com.shop.controller.viewObject.UserVO;
import com.shop.error.BussinessErrorEnum;
import com.shop.error.BussinessException;
import com.shop.response.CommonReturnType;
import com.shop.service.UserService;
import com.shop.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @Desc
 * @Author liuyicen
 * @CreateTime 2019-07-28 22:00
 * controller用来被spring扫描到，requestMapping用于url上/user方式访问
 */
@Controller("user")
@RequestMapping("/user")
@CrossOrigin
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    private HttpServletRequest httpServletRequest;


    /**
     * 用户获取Otp验证码
     * @param telephone
     * @return
     */
    @RequestMapping(value = "/getotp" ,method = {RequestMethod.POST},consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public  CommonReturnType getOtp(@RequestParam(name = "telephone") String telephone){
        //需要按照一定规则来生成otp验证码
        Random random = new Random();
        Integer randomInt = random.nextInt(99999);
        randomInt += 10000;
        String otpCode =Integer.toString(randomInt);
        //将otp验证码和用户的手机关联,，使用httpsession的方式绑定它的手机号和otpcode，后期使用redis进行优化
        httpServletRequest.getSession().setAttribute(telephone,otpCode);
        //todo 将otp验证码通过短信通道发送给用户


        System.out.println("telephone:" + telephone + "&otpCode:" + otpCode);
        

        return CommonReturnType.create(null);
    }




    /**
     * RequestParam 接受入参
     *
     * @param id
     */
    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BussinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        if (userModel == null) {
            throw new BussinessException(BussinessErrorEnum.USER_NOT_EXIST);
        }

        //将核心领域模型用户对象转换为可供前端使用的展示领域模型
        UserVO userVO = convertFromModel(userModel);
        //返回通用对象
        return CommonReturnType.create(userVO);

    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);

        return userVO;
    }


}
