package com.example.linhnvph27778.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "CuaHang")
@Table(name = "cuahang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CuaHang {
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

    @Column(name = "diachi")
    @NotBlank(message = "Không được bỏ trống")
    private String diaChi;

    @Column(name = "thanhpho")
    @NotBlank(message = "Không được bỏ trống")
    private String thanhPho;

    @Column(name = "quocgia")
    @NotBlank(message = "Không được bỏ trống")
    private String quacGia;
}
