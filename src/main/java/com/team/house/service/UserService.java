package com.team.house.service;

import com.team.house.entity.Users;

public interface UserService {

    //注册用户
    public int regUser(Users users);

    //登录
    public Users Login(String username, String password);




}
