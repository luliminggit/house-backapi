package com.team.house.service;

import com.team.house.entity.Street;

import java.util.List;

public interface StreetService {
    //查询街道
    public List<Street> getStreetById(Integer id);
}
