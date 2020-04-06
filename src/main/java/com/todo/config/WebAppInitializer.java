package com.todo.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;

public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext aconfig = new AnnotationConfigWebApplicationContext();
        aconfig.register(WebConfig.class);

        DispatcherServlet ds = new DispatcherServlet(aconfig);

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",ds);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");

    }
}
