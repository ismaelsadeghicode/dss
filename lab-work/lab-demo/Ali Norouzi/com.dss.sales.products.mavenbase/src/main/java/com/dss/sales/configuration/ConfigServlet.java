/*package com.dss.sales.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.dss.*")
public class ConfigServlet implements WebMvcConfigurer {

    private File file;
    private File file1;
    private String url;
    private String username;
    private String password;
    private String driver;

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver internalviewResolver = new InternalResourceViewResolver();
        internalviewResolver.setPrefix("/views/");
        internalviewResolver.setSuffix(".jsp");
        return internalviewResolver;
    }

    @Override
    public void addResourceHandler(ResourceHandlerRegistry registry){
        registry
                .addResourceHandler("/webapp/resources/**")
              // ostad goft .addResourceLocations("classpath:/META-INF/resources/");
                .addResourceLocations("/webapp/resources/");
    }
}
    /*@Bean
    DriverManagerDataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        file = new File(path+"application.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
        driver=properties.getProperty("driver");
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }*/
/*LocalSessionFactoryBean sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        file1 = new File(path+"hibernate.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(file1));
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("com.dss");
        return sessionFactory;
    }*/


    /*HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager= new HibernateTransactionManager();
        This one is not session factory!
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }*/