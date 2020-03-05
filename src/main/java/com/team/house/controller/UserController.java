package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.service.UserService;
import com.team.house.until.FileUploadUtil;
import com.team.house.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController  //全返回数据
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    /**
     * 注册
     * @param users
     * @return
     */
    @RequestMapping(value = "/userReg")
    @CrossOrigin(value="*",allowCredentials ="true")
    public String userReg(Users users){
        //成功1  失败0
        int temp = userService.regUser(users);
        return "{\"result\":"+temp+"}";
    }
    /*
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/userLogin")
    @CrossOrigin(value="*",allowCredentials ="true")
    public String userLogin(String username, String password, HttpSession session){
        Users users = userService.Login(username, password);
        if(users==null){
            return "{\"result\":0}";  //登录失败
        }else{
            session.setAttribute("logininfo",users);
            session.setMaxInactiveInterval(6000);    //10分钟
            return "{\"result\":1}";  //登录成功
        }

    }



}
