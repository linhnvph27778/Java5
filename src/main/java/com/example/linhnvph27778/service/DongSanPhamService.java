package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.DongSanPham;
import com.example.linhnvph27778.model.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DongSanPhamService {
    List<DongSanPham> getAll();

    Optional<DongSanPham> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(DongSanPham dongSanPham);

    Page<DongSanPham> phanTrang(Integer pageNo, Integer size);
}
