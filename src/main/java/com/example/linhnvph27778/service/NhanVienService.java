package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.NhanVien;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {
    ArrayList<NhanVien> getAll();

    Optional<NhanVien> getById(UUID id);

    void delete(UUID id);

    void addOrUpdate(NhanVien nhanVien);

    Page<NhanVien> phanTrang(Integer pageNo, Integer size);

    boolean getByMa(String ma);

    NhanVien loginNhanVien(String ma,String matKhau);

    Page<NhanVien> search(String keyword,String chucVu,Integer pageNo, Integer size);
}
