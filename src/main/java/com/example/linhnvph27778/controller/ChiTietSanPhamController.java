package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.ChiTietSanPham;
import com.example.linhnvph27778.service.ChiTietSPService;
import com.example.linhnvph27778.service.DongSanPhamService;
import com.example.linhnvph27778.service.MauSacService;
import com.example.linhnvph27778.service.NhaSanXuatService;
import com.example.linhnvph27778.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("/hien-thi")
    public String getData(Model model){
        //sap xep theo so luong tồn
        model.addAttribute("list",chiTietSPService.getAll());
        model.addAttribute("view","/views/chitietsp/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
        model.addAttribute("ctsp",chiTietSanPham);
        model.addAttribute("sanPham",sanPhamService.getAll());
        model.addAttribute("mauSac",mauSacService.getAll());
        model.addAttribute("dongSP",dongSanPhamService.getAll());
        model.addAttribute("nsx",nhaSanXuatService.getAll());
        model.addAttribute("view","/views/chitietsp/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham, BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("sanPham",sanPhamService.getAll());
            model.addAttribute("mauSac",mauSacService.getAll());
            model.addAttribute("dongSP",dongSanPhamService.getAll());
            model.addAttribute("nsx",nhaSanXuatService.getAll());
            model.addAttribute("view","/views/chitietsp/add.jsp");
            return "layout";
        }else {
            chiTietSPService.saveOrUpdate(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        chiTietSPService.delete(id);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable("id")UUID id,Model model){
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSPService.getById(id);
        model.addAttribute("ctsp",chiTietSanPham);
        model.addAttribute("sanPham",sanPhamService.getAll());
        model.addAttribute("mauSac",mauSacService.getAll());
        model.addAttribute("dongSP",dongSanPhamService.getAll());
        model.addAttribute("nsx",nhaSanXuatService.getAll());
        model.addAttribute("view","/views/chitietsp/update.jsp");
        return "layout";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("ctsp") ChiTietSanPham chiTietSanPham, BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("sanPham",sanPhamService.getAll());
            model.addAttribute("mauSac",mauSacService.getAll());
            model.addAttribute("dongSP",dongSanPhamService.getAll());
            model.addAttribute("nsx",nhaSanXuatService.getAll());
            model.addAttribute("view","/views/chitietsp/add.jsp");
            return "layout";
        }else {
            chiTietSPService.saveOrUpdate(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/hien-thi";
        }
    }
}
