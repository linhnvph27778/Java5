package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.KhachHang;
import com.example.linhnvph27778.model.NhanVien;
import com.example.linhnvph27778.service.KhachHangService;
import com.example.linhnvph27778.service.NhanVienService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private HttpServletRequest request;



    @GetMapping("/nhan-vien")
    public String loginNhanVien(Model model){
        model.addAttribute("action","/login/dang-nhap-nhan-vien");
        model.addAttribute("tieuDe","Quản lý nhân viên");
        return "login";
    }

    @PostMapping("/dang-nhap-nhan-vien")
    public String dangNhapNhanVien(@RequestParam("ten")String ten,@RequestParam("matKhau") String matKhau, Model model){
        NhanVien nv = nhanVienService.loginNhanVien(ten, matKhau);
        HttpSession session = request.getSession();
            if (ten.isEmpty() || matKhau.isEmpty()){
                model.addAttribute("mes","Không được bỏ trống");
                session.setAttribute("error","Không được bỏ trống");
                return "login";
            }else if (nv==null){
                session.setAttribute("error","Sai tên hoặc mk");
                model.addAttribute("tieuDe","Quản lý nhân viên");
                return "login";
            }
        session.setAttribute("nhanVien",nv);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/khach-hang")
    public String loginKhachHang(Model model){
        model.addAttribute("action","/login/dang-nhap-khach-hang");
        model.addAttribute("tieuDe","Đăng nhập");
        return "login";
    }

    @PostMapping("/dang-nhap-khach-hang")
    public String dangNhapKhachHang(@RequestParam("ten")String ten,@RequestParam("matKhau") String matKhau,Model model){
        KhachHang khachHang = khachHangService.loginKhachHang(ten, matKhau);
        HttpSession session = request.getSession();
        if (ten.isEmpty() || matKhau.isEmpty()){
            model.addAttribute("tieuDe","Đăng nhập");
            session.setAttribute("error","Không được bỏ trống");
            return "login";
        }else if (khachHang==null){
            model.addAttribute("tieuDe","Đăng nhập");
            session.setAttribute("error","Sai tên hoặc mk");
            return "login";
        }
        session.setAttribute("khachHang",khachHang);
//        model.addAttribute("view","/mua-hang/hien-thi");
//        model.addAttribute("view","/views/banhang/chitietsanpham.jsp");
//        return "banhang/layout";
        return "redirect:/mua-hang/hien-thi";
    }
}
