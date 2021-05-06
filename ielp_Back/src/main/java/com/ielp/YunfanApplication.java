package com.ielp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ielp.mapper")
public class YunfanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunfanApplication.class, args);
    }

}
