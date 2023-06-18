package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.CuaHang;
import com.example.linhnvph27778.repository.CuaHangReporitory;
import com.example.linhnvph27778.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangReporitory cuaHangReporitory;
    @Override
    public List<CuaHang> getAll() {
        return cuaHangReporitory.findAll();
    }

    @Override
    public Optional<CuaHang> getById(UUID id) {
        return cuaHangReporitory.findById(id);
    }

    @Override
    public void delete(UUID id) {
        cuaHangReporitory.deleteById(id);
    }

    @Override
    public void saveOrUpdate(CuaHang cuaHang) {
        cuaHangReporitory.save(cuaHang);
    }

    @Override
    public Page<CuaHang> phanTrang(Integer pageNo, Integer size) {
        PageRequest pageRequest = PageRequest.of(pageNo,size);
        return cuaHangReporitory.findAll(pageRequest);
    }
}
