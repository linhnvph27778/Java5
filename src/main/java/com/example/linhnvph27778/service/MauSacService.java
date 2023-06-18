package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.MauSac;
import com.example.linhnvph27778.model.SanPham;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    Optional<MauSac> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(MauSac sanPham);

    Page<MauSac> phanTrang(Integer pageNo, Integer size);
}
