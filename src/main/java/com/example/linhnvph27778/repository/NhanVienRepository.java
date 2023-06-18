package com.example.linhnvph27778.repository;

import com.example.linhnvph27778.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {

    public NhanVien findByMa(String ma);

    @Query("select nv from NhanVien nv where nv.ma=?1 and nv.matKhau=?2")
    NhanVien findByTenEndMatKhau(String ma,String matKhau);

    @Query("select nhanvien from  NhanVien nhanvien where nhanvien.ma like %:keyword% and nhanvien.chucVu.ma like:chucVu")
    Page<NhanVien> timKiem(String keyword,String chucVu, Pageable pageable);

}
