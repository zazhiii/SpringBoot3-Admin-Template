package com.zazhi.springboot3admintemplate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zazhi.springboot3admintemplate.mapper")
public class Springboot3AdminTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3AdminTemplateApplication.class, args);
    }

}
