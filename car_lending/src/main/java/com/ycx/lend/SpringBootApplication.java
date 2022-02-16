package com.ycx.lend;

import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
@MapperScan(basePackages = {"com.ycx.lend.mapper"})
public class SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
