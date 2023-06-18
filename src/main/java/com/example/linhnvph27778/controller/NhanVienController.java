package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.NhanVien;
import com.example.linhnvph27778.service.ChucVuService;
import com.example.linhnvph27778.service.CuaHangService;
import com.example.linhnvph27778.service.NhanVienService;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @RequestParam(name = "page",defaultValue = "0") Integer pageNo) {
        Page<NhanVien> nhanVienPage = nhanVienService.phanTrang(pageNo,3);
        model.addAttribute("list",nhanVienPage);
        model.addAttribute("chucVu",chucVuService.getAll());
        model.addAttribute("view","/views/nhanvien/index.jsp");
        return "layout";
    }

    @ResponseBody
    @GetMapping("/phan-trang")
    public List<NhanVien> phanTrang(@RequestParam(value = "pageNo",defaultValue = "0") Integer page) {
        return nhanVienService.phanTrang(page, 2).getContent();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") UUID id){
        nhanVienService.delete(id);
        System.out.println("id");
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/viewAdd")
    public String viewAdd(Model model){
        NhanVien nhanVien = new NhanVien();
        model.addAttribute("nhanvien",nhanVien);
        model.addAttribute("chucVu",chucVuService.getAll());
        model.addAttribute("cuaHang",cuaHangService.getAll());
        model.addAttribute("view","/views/nhanvien/add.jsp");
        return "layout";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("nhanvien") NhanVien nhanVien, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("chucVu",chucVuService.getAll());
            model.addAttribute("cuaHang",cuaHangService.getAll());
            model.addAttribute("view","/views/nhanvien/add.jsp");
            return "layout";
        }else {
            if(nhanVienService.getByMa(nhanVien.getMa())==false){
                model.addAttribute("mes","trung ma");
                model.addAttribute("chucVu",chucVuService.getAll());
                model.addAttribute("cuaHang",cuaHangService.getAll());
                System.out.println("ma nv 1:"+nhanVien.getMa());
                return "nhanvien/add";
            }else {
                System.out.println("ma nv 2:"+nhanVien.getMa());
                nhanVienService.addOrUpdate(nhanVien);
                return "redirect:/nhan-vien/hien-thi";
            }
        }
    }
    @GetMapping("/viewUpdate/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model){
        Optional<NhanVien> nhanVien = nhanVienService.getById(id);
        System.out.println(nhanVien.toString());
        model.addAttribute("chucVu",chucVuService.getAll());
        model.addAttribute("cuaHang",cuaHangService.getAll());
        model.addAttribute("nhanVien",nhanVien);
        model.addAttribute("view","/views/nhanvien/update.jsp");
        return "layout";
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("chucVu",chucVuService.getAll());
            model.addAttribute("cuaHang",cuaHangService.getAll());
            model.addAttribute("view","/views/nhanvien/update.jsp");
            return "layout";
        }else {
            nhanVienService.addOrUpdate(nhanVien);
            return "redirect:/nhan-vien/hien-thi";
        }
    }
    @GetMapping("/search")
    public String search(Model model,@RequestParam("keyword")String keyword,
                         @RequestParam("chucVu") String chucVu,
                         @RequestParam(name = "page",defaultValue = "0") Integer pageNo
    ){
        model.addAttribute("chucVu",chucVuService.getAll());
        model.addAttribute("list",nhanVienService.search(keyword,chucVu,pageNo,5));

        model.addAttribute("view","/views/nhanvien/index.jsp");
        return "layout";
    }

}
