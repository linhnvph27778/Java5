package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.SanPham;
import com.example.linhnvph27778.service.SanPhamService;
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
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<SanPham> sanPhamPage =sanPhamService.phanTrang(page,4);
        model.addAttribute("list",sanPhamPage);
        model.addAttribute("view","/views/sanpham/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        SanPham sanPham = new SanPham();
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("view","/views/sanpham/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("sanPham")SanPham sanPham, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/sanpham/add.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id,Model model){
        sanPhamService.delete(id);
        return "redirect:/san-pham/hien-thi";

    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<SanPham> sanPham = sanPhamService.getById(id);
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("view","/views/sanpham/update.jsp");
        return "layout";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") SanPham sp,
            @Valid @ModelAttribute("sanPham")SanPham sanPham, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/sanpham/update.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(sanPham);
            return "redirect:/san-pham/hien-thi";
        }
    }
    @GetMapping("/search")
    public String search(Model model,@RequestParam("keyword")String keyword,
                         @RequestParam(name = "page",defaultValue = "0") Integer pageNo){
        model.addAttribute("list",sanPhamService.timKiem(keyword,pageNo,5));
        model.addAttribute("view","/views/sanpham/index.jsp");
        return "layout";
    }
}
