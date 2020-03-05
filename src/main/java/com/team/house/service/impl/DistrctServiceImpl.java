package com.team.house.service.impl;

import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrctServiceImpl implements DistrictService {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    /**
     * 查询所有区域
     * @return
     */
    @Override
    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
