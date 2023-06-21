package com.example.qichengmall.config;

import com.example.qichengmall.intercepter.RoleCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EmployeeWebConfig implements WebMvcConfigurer {
    @Autowired
    private RoleCheckInterceptor roleCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(roleCheckInterceptor).addPathPatterns("/employee/**")
                .addPathPatterns("/order/uploadExcel")
                .excludePathPatterns("/employee/logout","/employee/login");

    }
}
