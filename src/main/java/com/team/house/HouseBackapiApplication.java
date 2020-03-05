package com.team.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//使用@MapperScan在启动类上添加扫描mybatis的Dao层接口生成实现类对象
@MapperScan(value = "com.team.house.mapper")
public class HouseBackapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseBackapiApplication.class, args);
    }

}
