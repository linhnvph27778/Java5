package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.GioHang;
import com.example.linhnvph27778.repository.GioHangRepository;
import com.example.linhnvph27778.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GioHangServiceImpl implements GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    @Override
    public List<GioHang> getAll() {
        return gioHangRepository.findAll();
    }
}
