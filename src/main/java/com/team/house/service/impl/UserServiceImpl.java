package com.team.house.service.impl;

import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.DistrictService;
import com.team.house.service.UserService;
import com.team.house.until.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UsersMapper usersMapper;

    /**
     * 注册用户
     * @param users
     * @return
     */
    @Override
    public int regUser(Users users) {
        //使用md5密码加密后进行数据存储
        //1.导入md5工具类  2.调用md5工具类的方法进行加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Users Login(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if(list!=null&&list.size()==1){
            return list.get(0); //返回第一个对象
        }else{
            return null;
        }
    }
}
