package com.team.house.mapper;

import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.until.HouseCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> getHouseByid(Integer id);

    List<House> getAllHouse(HouseCondition houseCondition);

}