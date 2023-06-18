package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.ChucVu;
import com.example.linhnvph27778.model.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();

    Optional<ChucVu> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(ChucVu chucVu);

    Page<ChucVu> phanTrang(Integer pageNo, Integer size);
}
