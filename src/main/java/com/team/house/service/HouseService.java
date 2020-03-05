package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.until.HouseCondition;
import com.team.house.until.PageMeter;

public interface HouseService {

    //发布出租房
    public int addHouse(House house);

    //根据用户id查询发布的租房信息
    PageInfo<House> getHouseById(Integer id, PageMeter pageMeter);

    //删除租房信息
    public int deleteHouse(String id);

    //查询所有租房信息
    PageInfo<House> getAllHouse(HouseCondition houseCondition);


}
