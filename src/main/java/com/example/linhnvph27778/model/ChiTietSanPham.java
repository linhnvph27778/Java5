package com.example.linhnvph27778.model;

import com.example.linhnvph27778.viewmodel.ChiTietSanPhamVm;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity(name = "ChiTietSanPham")
@Table(name = "ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {

    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nambh")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private int namBH;

    @Column(name = "mota")
    @NotBlank(message = "Không được bỏ trống")
    private String moTa;

    @Column(name = "soluongton")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private int soLuongTon;

    @Column(name = "gianhap")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private double giaNhap;

    @Column(name = "giaban")
    @NotNull(message = "Khong được bỏ trống")
    @DecimalMin(value = "1",message = "Phải lơn hơn 0")
    private double giaBan;

    @ManyToOne
    @JoinColumn(name = "idSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "idNsx")
    private NhaSanXuat nhaSanXuat;

    @ManyToOne
    @JoinColumn(name = "idMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "idDongSP")
    private DongSanPham dongSanPham;


}
