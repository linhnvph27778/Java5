package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.HoaDonChiTiet;
import com.example.linhnvph27778.model.IdHoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, IdHoaDonChiTiet> {
}
