package com.czlt.reproduction.mgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.czlt.reproduction.mgr.mapper")
@SpringBootApplication
public class MgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(MgrApplication.class, args);
    }

}
