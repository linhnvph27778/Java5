package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.KhachHang;
import com.example.linhnvph27778.model.NhanVien;
import com.example.linhnvph27778.repository.KhachHangRepository;
import com.example.linhnvph27778.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);

        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void addOrUpdate(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Optional<KhachHang> getOne(UUID id) {
        return khachHangRepository.findById(id);
    }

    @Override
    public KhachHang loginKhachHang(String ma, String matKhau) {
        return khachHangRepository.findByTenEndMatKhau(ma, matKhau);
    }

    @Override
    public Page<KhachHang> search(String keyword, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return khachHangRepository.search(keyword,pageable);
    }

}
