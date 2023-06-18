package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("select nv from KhachHang nv where nv.ma=?1 and nv.matKhau=?2")
    KhachHang findByTenEndMatKhau(String ma, String matKhau);

    @Query("select kh from  KhachHang kh where kh.ten like %:keyword% or kh.ma like %:keyword%")
    Page<KhachHang> search(String keyword, Pageable pageable);
}
