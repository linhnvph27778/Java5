package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.CuaHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    Optional<CuaHang> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(CuaHang cuaHang);

    Page<CuaHang> phanTrang(Integer pageNo, Integer size);
}
