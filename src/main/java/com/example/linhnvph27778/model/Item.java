package com.example.linhnvph27778.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Item {
    private UUID idCtsp;
    private String tenSanPham;
    private String tenMau;
    private String tenNSX;
    private String tenDongSP;
    private int soLuong;
    private double giaBan;
}
