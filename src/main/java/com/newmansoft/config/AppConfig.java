package com.newmansoft.config;

import com.newmansoft.filter.CORSFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;

/**
 * Created by user on 1/23/2015.
 */
@Configuration
@ComponentScan("com.newmansoft")
@EnableWebMvc
//@EnableAutoConfiguration
public class AppConfig {


    @Bean
    public Filter corsFilter() {
        return new CORSFilter();
    }


}

