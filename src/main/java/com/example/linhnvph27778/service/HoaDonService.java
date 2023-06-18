package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> getAll();

    void add(HoaDon hoaDon);
}
