package com.example.linhnvph27778.model;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "GioHangChiTiet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GioHangChiTiet{
    @EmbeddedId
    private IdGioHangChiTiet id;

    @Column(name = "soluong")
    private int soLuong;

    @Column(name = "dongia")
    private double donGia;

    @Column(name = "dongiakhigiam")
    private double donGiaKhiGiam;

//    @ManyToOne
//    @JoinColumn(name = "idgiohang" ,insertable=false, updatable=false)
//    private GioHang gioHang;
//
//    @ManyToOne
//    @JoinColumn(name = "idchitietsp" ,insertable=false, updatable=false)
//    private ChiTietSanPham chiTietSanPham;
}
