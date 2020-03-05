package com.team.house.controller;


import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    /**
     *加载
     * @return
     */
    @RequestMapping(value = "/getAllDistrict")
    @CrossOrigin(value="*",allowCredentials ="true")
    public List<District>  getAllDistrict(){
        return districtService.getAllDistrict();
    }



}
