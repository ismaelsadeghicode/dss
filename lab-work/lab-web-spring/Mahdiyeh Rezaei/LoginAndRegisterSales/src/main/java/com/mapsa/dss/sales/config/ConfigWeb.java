package com.mapsa.dss.sales.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ConfigWeb extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ConfigBeans.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
