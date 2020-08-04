package com.dss.sales.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.dss.sales")
public class ConfigServlet {
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalviewResolver = new InternalResourceViewResolver();
        internalviewResolver.setPrefix("/views/");
        internalviewResolver.setSuffix(".jsp");
        return internalviewResolver;
    }
}
