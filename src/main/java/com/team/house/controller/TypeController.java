package com.team.house.controller;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @CrossOrigin(value="*",allowCredentials ="true")
    @RequestMapping(value = "/getTypes")
    public List<Type> getAllType(){
        List<Type> list = typeService.getAllType();
        return list;
    }



}
