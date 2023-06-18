package com.example.linhnvph27778.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "HoaDonChiTiet")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(IdHoaDonChiTiet.class)

public class HoaDonChiTiet {
    @Id
    private UUID idChiTietSP;

    @Id
    private UUID idHoaDon;

    private Integer soLuong;

    private double donGia;


}
