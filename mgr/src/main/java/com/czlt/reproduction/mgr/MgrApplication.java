package com.czlt.reproduction.mgr;

import com.czlt.reproduction.mgr.servlet.ApiServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;


@MapperScan("com.czlt.reproduction.mgr.mapper")
@EnableAsync
@SpringBootApplication
public class MgrApplication {
    @Bean
    public ServletRegistrationBean apiServletRegistrationBean() {
        ServletRegistrationBean apiServletRegistration = new ServletRegistrationBean(new ApiServlet());
        apiServletRegistration.setEnabled(true);
        apiServletRegistration.addUrlMappings("/apiServlet");
        return apiServletRegistration;
    }

    public static void main(String[] args) {
        SpringApplication.run(MgrApplication.class, args);
    }
}
