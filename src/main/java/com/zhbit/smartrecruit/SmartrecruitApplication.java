package com.zhbit.smartrecruit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.zhbit.smartrecruit.dao")
public class SmartrecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartrecruitApplication.class, args);
    }

}
