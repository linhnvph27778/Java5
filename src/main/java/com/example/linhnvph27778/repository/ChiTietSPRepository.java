package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSanPham, UUID> {

}
