package com.newmansoft.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by user on 1/23/2015.
 */
@Configuration
@ComponentScan("com.newmansoft")
@EnableWebMvc
public class AppConfig {
}

