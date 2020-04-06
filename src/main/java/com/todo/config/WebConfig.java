package com.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.todo"})
public class WebConfig {
    private static final String PREFIX="/WEB-INF/views/";
    private static final String SUFFIX=".jsp";

    @Bean
    public ViewResolver viewResolver(){
        UrlBasedViewResolver view = new InternalResourceViewResolver();
        view.setPrefix(PREFIX);
        view.setSuffix(SUFFIX);
        return view;
    }
}
