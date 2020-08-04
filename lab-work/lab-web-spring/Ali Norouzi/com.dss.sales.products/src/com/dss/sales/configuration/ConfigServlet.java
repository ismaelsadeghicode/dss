package com.dss.sales.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.dss.*")
public class ConfigServlet implements WebMvcConfigurer {
    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalviewResolver = new InternalResourceViewResolver();
        internalviewResolver.setPrefix("/views/");
        internalviewResolver.setSuffix(".jsp");
        return internalviewResolver;
    }


    public void addResourceHandler(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/web/resources/**")
                .addResourceLocations("/web/resources/");
    }
}
