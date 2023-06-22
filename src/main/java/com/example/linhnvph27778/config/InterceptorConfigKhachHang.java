package com.example.linhnvph27778.config;

import com.example.linhnvph27778.interceptors.AuthenticateKhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigKhachHang implements WebMvcConfigurer {
    @Autowired
    private AuthenticateKhachHang authenticateKhachHang;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticateKhachHang).
                addPathPatterns("/mua-hang/mua-mot-sp","/mua-hang/mua-tat-ca").
                excludePathPatterns("/login/khach-hang");

    }
}
