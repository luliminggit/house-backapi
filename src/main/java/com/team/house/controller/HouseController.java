package com.team.house.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.until.FileUploadUtil;
import com.team.house.until.HouseCondition;
import com.team.house.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HouseController {

  @Autowired
  private HouseService houseService;

    /**
     * 发布房屋信息
     * @param house
     * @param session
     * @return
     */
    @RequestMapping(value = "/fabuHouse")
    @CrossOrigin(value="*",allowCredentials ="true")
    public String addHouse(House house, HttpSession session,@RequestParam(name = "file", required = false) MultipartFile file){
        try{
            //文件上传:一个MultipartFile类的对象对应一个表单中上传的文件
            String path="c:\\images";//设置文件存储位置
            String filename = FileUploadUtil.upload(file, path);
            //设置出租房的编号   利用时间毫秒数
            house.setId(System.currentTimeMillis()+"");
            //获取登入人的编号
            Users users=(Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            //3设置保存文件的路径
            house.setPath(filename); //保存文件名即可
            houseService.addHouse(house);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":0}";
    }

    /**
     * //根据用户id查询发布的租房信息
     * @param pageMeter
     * @return
     */

    @RequestMapping(value = "/getHouseByPage")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public Map<String,Object> getHouseById(PageMeter pageMeter,HttpSession session){
        //获取登入人的编号
        Users users=(Users) session.getAttribute("logininfo");
        PageInfo<House> pageInfo= houseService.getHouseById(users.getId(),pageMeter);
        //返回多块信息:如总页，当前页的记录
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());//封装总页数
        map.put("rows",pageInfo.getList()); //封装当前页的记录
        return map;
    }

    /**
     * 删除租房信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteHouse")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public String deleteHouse(String id,String filename){
        int i = houseService.deleteHouse(id);
        if(i>0){

            File file=new File("c:\\images\\"+filename);
            if(file.exists()){
                file.delete();
            }
            return "{\"result\":1}";
        }else{
            return "{\"result\":0}";
        }

    }

    /**
     * 查询所有租房信息
     * @param houseCondition
     * @return
     */
    @RequestMapping(value = "/getAllHouse")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public Map<String,Object> getAllHouse(HouseCondition houseCondition){
        PageInfo<House> pageInfo  = houseService.getAllHouse(houseCondition);
        //返回多块信息:如总页，当前页的记录
        Map<String,Object> map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages()); //封装总页数
        map.put("row",pageInfo.getList()); //封装当前页的记录
        return map;
    }



}
