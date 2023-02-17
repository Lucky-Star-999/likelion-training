package com.example.practiceweek8.config;

import com.example.practiceweek8.interceptor.DepartmentDtoServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class DepartmentDtoServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private DepartmentDtoServiceInterceptor departmentDtoServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(departmentDtoServiceInterceptor);
    }
}
