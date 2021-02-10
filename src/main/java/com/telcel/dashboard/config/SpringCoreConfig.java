package com.telcel.dashboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author VG2XXAH
 */
@EnableWebMvc
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.telcel.dashboard")
public class SpringCoreConfig {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean(name = "querys")
    public PropertiesFactoryBean querysFolioProblema() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(resourceLoader.getResource("classpath:properties/querys.xml"));
        propertiesFactoryBean.setIgnoreResourceNotFound(false);
        return propertiesFactoryBean;
    }

}
