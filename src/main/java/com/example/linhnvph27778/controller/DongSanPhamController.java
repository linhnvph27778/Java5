package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.DongSanPham;
import com.example.linhnvph27778.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham")
public class DongSanPhamController {
    @Autowired
    private DongSanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<DongSanPham> sanPhamPage =sanPhamService.phanTrang(page,4);
        model.addAttribute("list",sanPhamPage);
        model.addAttribute("view","/views/dongsanpham/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        DongSanPham dongSanPham = new DongSanPham();
        model.addAttribute("dongSanPham",dongSanPham);
        model.addAttribute("view","/views/dongsanpham/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("dongSanPham")DongSanPham dongSanPham, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/dongsanpham/add.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(dongSanPham);
            return "redirect:/dong-san-pham/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sanPhamService.delete(id);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<DongSanPham> dongSanPham = sanPhamService.getById(id);
        model.addAttribute("dongSanPham",dongSanPham);
        model.addAttribute("view","/views/dongsanpham/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("dongSanPham")DongSanPham dongSanPham, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/dongsanpham/update.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(dongSanPham);
            return "redirect:/dong-san-pham/hien-thi";
        }
    }
}
