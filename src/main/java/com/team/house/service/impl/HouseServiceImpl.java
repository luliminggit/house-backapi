package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.DistrictService;
import com.team.house.service.HouseService;
import com.team.house.until.HouseCondition;
import com.team.house.until.PageMeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    /**
     * 发布房屋信息
     * @param house
     * @return
     */
    @Override()
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    /**
     * //根据用户id查询发布的租房信息
     * @param id
     * @param pageMeter
     * @return
     */
    @Override
    public PageInfo<House> getHouseById(Integer id, PageMeter pageMeter) {
        PageHelper.startPage(pageMeter.getPage(),pageMeter.getPageSize());
        List<House> list = houseMapper.getHouseByid(id);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 删除租房信息
     * @param id
     * @return
     */
    @Override
    public int deleteHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询所有租房信息
     * @param houseCondition
     * @return
     */
    @Override
    public PageInfo<House> getAllHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list = houseMapper.getAllHouse(houseCondition);
        PageInfo<House> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }


}
