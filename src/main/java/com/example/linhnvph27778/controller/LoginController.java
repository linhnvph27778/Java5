package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.KhachHang;
import com.example.linhnvph27778.model.NhanVien;
import com.example.linhnvph27778.service.KhachHangService;
import com.example.linhnvph27778.service.NhaSanXuatService;
import com.example.linhnvph27778.service.NhanVienService;
import com.example.linhnvph27778.viewmodel.NhanVienVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/nhan-vien")
    public String loginNhanVien(Model model){
        model.addAttribute("action","/login/dang-nhap-nhan-vien");
        model.addAttribute("tieuDe","Quản lý nhân viên");
        return "login";
    }

    @PostMapping("/dang-nhap-nhan-vien")
    public String dangNhapNhanVien(@RequestParam("ten")String ten,@RequestParam("matKhau") String matKhau, Model model){
        NhanVien nv = nhanVienService.loginNhanVien(ten, matKhau);
            if (ten.isEmpty() || matKhau.isEmpty()){
                model.addAttribute("mes","Không được bỏ trống");
                model.addAttribute("tieuDe","Quản lý nhân viên");
                return "login";
            }else if (nv==null){
                model.addAttribute("mes","Sai tên hoặc mk");
                model.addAttribute("tieuDe","Quản lý nhân viên");
                return "login";
            }
            System.out.println(nv);
            return "layout";
    }

    @GetMapping("/khach-hang")
    public String loginKhachHang(Model model){
        model.addAttribute("action","/login/dang-nhap-khach-hang");
        model.addAttribute("tieuDe","Đăng nhập");
        return "login";
    }

    @PostMapping("/dang-nhap-khach-hang")
    public String dangNhapKhachHang(@RequestParam("ten")String ten,@RequestParam("matKhau") String matKhau,Model model){
        KhachHang nv = khachHangService.loginKhachHang(ten, matKhau);
        if (ten.isEmpty() || matKhau.isEmpty()){
            model.addAttribute("mes","Không được bỏ trống");
            model.addAttribute("tieuDe","Đăng nhập");
            return "login";
        }else if (nv==null){
            model.addAttribute("mes","Sai tên hoặc mk");
            model.addAttribute("tieuDe","Đăng nhập");
            return "login";
        }
        model.addAttribute("view","/views/banhang/chitietsanpham.jsp");
        return "banhang/layout";
    }
}
