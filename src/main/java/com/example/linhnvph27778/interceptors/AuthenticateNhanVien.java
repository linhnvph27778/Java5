package com.example.linhnvph27778.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@Component
public class AuthenticateNhanVien implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handle
    ) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("nhanVien")==null){
            session.setAttribute("error","Vui lòng đăng nhập");
            response.sendRedirect(request.getContextPath()+"/login/nhan-vien");
            return false;
        }
        return true;
    }
}
