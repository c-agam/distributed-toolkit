package com.czlt.reproduction.mgr.conf;

import com.czlt.reproduction.mgr.servlet.ApiServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ApiServlet apiServlet(){
        return new ApiServlet();
    }

    @Bean
    public ServletRegistrationBean apiServletRegistrationBean(ApiServlet apiServlet) {
        ServletRegistrationBean apiServletRegistration = new ServletRegistrationBean(apiServlet);
        apiServletRegistration.setEnabled(true);
        apiServletRegistration.addUrlMappings("/apiServlet");
        return apiServletRegistration;
    }
}
