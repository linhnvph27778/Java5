package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.ChucVu;
import com.example.linhnvph27778.model.CuaHang;
import com.example.linhnvph27778.service.CuaHangService;
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
@RequestMapping("/cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("/hien-thi")
    public String getAll(Model model, @RequestParam(value = "page",defaultValue = "0")Integer page){
        Page<CuaHang> cuaHangPage = cuaHangService.phanTrang(page,3);
        model.addAttribute("list",cuaHangPage);
        model.addAttribute("view","/views/cuahang/index.jsp");
        return "layout";
    }
    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        CuaHang cuaHang = new CuaHang();
        model.addAttribute("cuaHang",cuaHang);
        model.addAttribute("view","/views/cuahang/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("cuaHang")CuaHang cuaHang, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/cuahang/add.jsp");
            return "layout";
        }else {
            cuaHangService.saveOrUpdate(cuaHang);
            return "redirect:/cua-hang/hien-thi";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        cuaHangService.delete(id);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("/viewUpdate/{id}")
    public String update(@PathVariable("id") UUID id,Model model){
        Optional<CuaHang> cuaHang = cuaHangService.getById(id);
        model.addAttribute("cuaHang",cuaHang);
        model.addAttribute("view","/views/cuahang/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("cuaHang")CuaHang cuaHang, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("view","/views/cuahang/update.jsp");
            return "layout";
        }else {
            cuaHangService.saveOrUpdate(cuaHang);
            return "redirect:/cua-hang/hien-thi";
        }
    }
}
