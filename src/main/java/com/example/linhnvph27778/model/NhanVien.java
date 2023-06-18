package com.example.linhnvph27778.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity(name = "NhanVien")
@Table(name = "NhanVien")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NhanVien {

    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Không được bỏ trống")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Không được bỏ trống")
    private String ten;

    @Column(name = "TenDem")
    @NotBlank(message = "Không được bỏ trống")
    private String tenDem;

    @Column(name = "Ho")
    @NotBlank(message = "Không được bỏ trống")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được bỏ trống")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    @NotBlank(message = "Không được bỏ trống")
    private String diaChi;

    @Column(name = "Sdt")
    @NotBlank(message = "Không được bỏ trống")
    private String sdt;

    @Column(name = "MatKhau")
    @NotBlank(message = "Không được bỏ trống")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCV")
    private ChucVu chucVu;

    @Column(name = "TrangThai")
    @NotNull(message = "Không được bỏ trống")
    private int trangThai;
}
