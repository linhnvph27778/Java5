package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.NhaSanXuat;
import com.example.linhnvph27778.model.SanPham;
import com.example.linhnvph27778.service.NhaSanXuatService;
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
@RequestMapping("/nha-san-xuat")
public class NhaSanXuatController {
    @Autowired
    private NhaSanXuatService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<NhaSanXuat> sanPhamPage =sanPhamService.phanTrang(page,3);
        model.addAttribute("list",sanPhamPage);
        model.addAttribute("view","/views/nhasanxuat/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        NhaSanXuat nhaSanXuat = new NhaSanXuat();
        model.addAttribute("nhaSanXuat",nhaSanXuat);
        model.addAttribute("view","/views/nhasanxuat/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("nhaSanXuat")NhaSanXuat nhaSanXuat, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/nhasanxuat/add.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(nhaSanXuat);
            return "redirect:/nha-san-xuat/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sanPhamService.delete(id);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<NhaSanXuat> nhaSanXuat = sanPhamService.getById(id);
        model.addAttribute("nhaSanXuat",nhaSanXuat);
        model.addAttribute("view","/views/nhasanxuat/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("nhaSanXuat")NhaSanXuat nhaSanXuat, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/nhasanxuat/update.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(nhaSanXuat);
            return "redirect:/nha-san-xuat/hien-thi";
        }
    }
}
