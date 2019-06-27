package com.czlt.reproduction.mgr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@MapperScan("com.czlt.reproduction.mgr.mapper")
@SpringBootApplication
public class MgrApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MgrApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MgrApplication.class, args);
    }

}
