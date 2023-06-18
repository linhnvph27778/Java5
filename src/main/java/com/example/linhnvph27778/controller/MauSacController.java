package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.MauSac;
import com.example.linhnvph27778.model.SanPham;
import com.example.linhnvph27778.service.MauSacService;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    private MauSacService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<MauSac> sanPhamPage =sanPhamService.phanTrang(page,3);
        model.addAttribute("list",sanPhamPage);
        model.addAttribute("view","/views/mausac/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        MauSac mauSac = new MauSac();
        model.addAttribute("mauSac",mauSac);
        model.addAttribute("view","/views/mausac/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("mauSac")MauSac mauSac, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/mausac/add.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(mauSac);
            return "redirect:/mau-sac/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sanPhamService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<MauSac> mauSac = sanPhamService.getById(id);
        model.addAttribute("mauSac",mauSac);
        model.addAttribute("view","/views/mausac/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("mauSac")MauSac mauSac, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/mausac/update.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(mauSac);
            return "redirect:/mau-sac/hien-thi";
        }
    }
}
