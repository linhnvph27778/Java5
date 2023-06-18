package com.example.linhnvph27778.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IdHoaDonChiTiet implements Serializable {

    @JoinColumn(name = "idhoadon")
    private UUID idHoaDon;

    @JoinColumn(name = "idchitietsp")
    private UUID idChiTietSP;

}
