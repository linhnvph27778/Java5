package com.example.linhnvph27778.config;

import com.example.linhnvph27778.interceptors.AuthenticateNhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigNhanVien implements WebMvcConfigurer {
    @Autowired
    private AuthenticateNhanVien authenticateNhanVien;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticateNhanVien).
                addPathPatterns("/san-pham/**","/nha-san-xuat/**","/nhan-vien/**","/mau-sac/**","/khach-hang/**",
                        "/dong-san-pham/**","/cua-hang/**","/chuc-vu/**","/chi-tiet-san-pham/**").
                excludePathPatterns("/login/nhan-vien");

    }
}
