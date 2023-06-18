package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();

    void add(HoaDonChiTiet hoaDonChiTiet);
}
