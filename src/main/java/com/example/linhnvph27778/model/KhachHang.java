package com.example.linhnvph27778.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Entity(name = "KhachHang")
@Table(name = "KhachHang")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class KhachHang {
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

    @Column(name = "ngaysinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Không được bỏ trống")
    private Date ngaySinh;

    @Column(name = "sdt")
    @NotBlank(message = "Không được bỏ trống")
    private String sdt;

    @Column(name = "diachi")
    @NotBlank(message = "Không được bỏ trống")
    private String diaChi;

    @Column(name = "thanhpho")
    @NotBlank(message = "Không được bỏ trống")
    private String thanhPho;

    @Column(name = "quocgia")
    @NotBlank(message = "Không được bỏ trống")
    private String quacGia;

    @Column(name = "matkhau")
    @NotBlank(message = "Không được bỏ trống")
    private String matKhau;
}
