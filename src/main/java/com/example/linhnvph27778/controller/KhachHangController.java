package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.KhachHang;
import com.example.linhnvph27778.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/hien-thi")
    public String getAll(Model model, @RequestParam(name = "page", defaultValue = "0")Integer pageNo){
        Page<KhachHang> khachHangPage = khachHangService.phanTrang(pageNo,3);
        model.addAttribute("list",khachHangPage);
        model.addAttribute("view","/views/khachhang/index.jsp");
        return "layout";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        khachHangService.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        KhachHang khachHang = new KhachHang();
        model.addAttribute("kh",khachHang);
        model.addAttribute("view","/views/khachhang/add.jsp");
        return "khachhang/add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("kh") KhachHang khachHang, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/khachhang/add.jsp");
            return "layout";
        }else {
            khachHangService.addOrUpdate(khachHang);
            return "redirect:/khach-hang/hien-thi";
        }
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id")UUID id,Model model){
        Optional<KhachHang> khachHang = khachHangService.getOne(id);
        model.addAttribute("kh",khachHang);
        model.addAttribute("view","/views/khachhang/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("kh")KhachHang khachHang,BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("view","/views/khachhang/update.jsp");
            return "layout";
        }else {
            khachHangService.addOrUpdate(khachHang);
            return "redirect:/khach-hang/hien-thi";
        }
    }
    @GetMapping("/search")
    public String search(Model model,@RequestParam("keyword")String keyword,
                         @RequestParam(name = "page",defaultValue = "0") Integer pageNo){
        model.addAttribute("list",khachHangService.search(keyword,pageNo,5));
        model.addAttribute("view","/views/nhanvien/index.jsp");
        return "layout";
    }
}
