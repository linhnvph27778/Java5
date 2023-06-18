package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    Optional<SanPham> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(SanPham sanPham);

    Page<SanPham> phanTrang(Integer pageNo,Integer size);

    Page<SanPham> timKiem(String keyword ,Integer pageNo,Integer size);

}
