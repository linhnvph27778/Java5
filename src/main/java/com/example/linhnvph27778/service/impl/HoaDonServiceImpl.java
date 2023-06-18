package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.HoaDon;
import com.example.linhnvph27778.repository.HoaDonRepository;
import com.example.linhnvph27778.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    @Override
    public List<HoaDon> getAll() {

        return hoaDonRepository.findAll();
    }

    @Override
    public void add(HoaDon hoaDon) {
        hoaDonRepository.save(hoaDon);
    }
}
