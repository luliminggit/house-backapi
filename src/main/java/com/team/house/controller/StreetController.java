package com.team.house.controller;

import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StreetController {

    @Autowired
    private StreetService streetService;

   @RequestMapping(value = "getStreetById")
   @CrossOrigin(value="*",allowCredentials ="true")
    public List<Street> getStreetById(Integer id){
        return streetService.getStreetById(id);
    }
}
