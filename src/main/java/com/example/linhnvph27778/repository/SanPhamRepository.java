package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
//    @Query("select sp from  SanPham sp where sp.ma like %:keyword% or sp.ten like %:keyword%")
//    Page<SanPham> timKiem(String keyword, Pageable pageable);
        @Query("select kh from  SanPham kh where kh.ten like %:keyword% or kh.ma like %:keyword%")
        Page<SanPham> search(String keyword, Pageable pageable);
}
