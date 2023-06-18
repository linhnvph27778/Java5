package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.NhanVien;
import com.example.linhnvph27778.repository.NhanVienRepository;
import com.example.linhnvph27778.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
//    @Query("from NhanVien join ChucVu on NhanVien.chucVu.id = ChucVu.id")
    public ArrayList<NhanVien> getAll() {
        return (ArrayList<NhanVien>) nhanVienRepository.findAll();
    }
    

    @Override
    public Optional<NhanVien> getById(UUID id) {
        return nhanVienRepository.findById(id);
    }


    @Override
    public void delete(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public void addOrUpdate(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

//    @Override
//    public boolean getByMa(NhanVien nhanVien) {
//        NhanVien nv = nhanVienRepository.save(nhanVien);
//        if (nhanVienRepository.findById(nv.getId()) != null){
//            return true;
//        }
//        return false;
//    }

    @Override
    public Page<NhanVien> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public boolean getByMa(String ma) {
        NhanVien nhanVien = nhanVienRepository.findByMa(ma);
        if (nhanVien.getMa().equals(ma)){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public NhanVien loginNhanVien(String ma, String matKhau) {
        return nhanVienRepository.findByTenEndMatKhau(ma,matKhau);
    }

    @Override
    public Page<NhanVien> search(String keyword,String chucVu, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return nhanVienRepository.timKiem(keyword,chucVu,pageable);
    }

//    @Override
//    public Boolean getByMa(String ma) {
////        NhanVien nv = nhanVienRepository.save(nhanVien);
//    }

}
