package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang> getAll();

    Page<KhachHang> phanTrang(Integer pageNo,Integer size);

    void addOrUpdate(KhachHang khachHang);

    void delete(UUID id);

    Optional<KhachHang> getOne(UUID id);

    KhachHang loginKhachHang(String ma,String matKhau);

    Page<KhachHang> search(String keyword,Integer pageNo,Integer size);
}
