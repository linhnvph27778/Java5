package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.GioHangChiTiet;
import com.example.linhnvph27778.repository.GioHangChiTietRepository;
import com.example.linhnvph27778.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GioHangChiTietServiceImpl implements GioHangChiTietService {
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Override
    public List<GioHangChiTiet> getAll() {
        return gioHangChiTietRepository.findAll();
    }
}
