package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.ChucVu;
import com.example.linhnvph27778.service.ChucVuService;
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
@RequestMapping("/chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService sanPhamService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page", defaultValue = "0") Integer page){
        Page<ChucVu> sanPhamPage =sanPhamService.phanTrang(page,3);
        model.addAttribute("list",sanPhamPage);
        model.addAttribute("view","/views/chucvu/index.jsp");
        return "layout";
    }

    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        ChucVu chucVu = new ChucVu();
        model.addAttribute("chucVu",chucVu);
        model.addAttribute("view","/views/chucvu/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("chucVu")ChucVu chucVu, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/chucvu/add.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(chucVu);
            return "redirect:/chuc-vu/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        sanPhamService.delete(id);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<ChucVu> chucVu = sanPhamService.getById(id);
        model.addAttribute("chucVu",chucVu);
        model.addAttribute("view","/views/chucvu/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("chucVu")ChucVu chucVu, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/chucvu/update.jsp");
            return "layout";
        }else {
            sanPhamService.saveOrUpdate(chucVu);
            return "redirect:/chuc-vu/hien-thi";
        }
    }
}
