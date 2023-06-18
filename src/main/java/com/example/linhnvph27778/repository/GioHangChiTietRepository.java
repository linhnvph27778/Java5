package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.GioHangChiTiet;
import com.example.linhnvph27778.model.IdGioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, IdGioHangChiTiet> {
}
