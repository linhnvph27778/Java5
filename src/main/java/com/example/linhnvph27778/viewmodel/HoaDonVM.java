package com.example.linhnvph27778.viewmodel;

import com.example.linhnvph27778.model.HoaDon;
import com.example.linhnvph27778.model.KhachHang;
import com.example.linhnvph27778.model.NhanVien;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class HoaDonVM {
    private String ma;
    private Date ngayTao;
    private int tinhTrang;

    public void loadFromEntity(HoaDon ch)
    {
        this.setMa( ch.getMa() );
        this.setNgayTao( ch.getNgayTao());
        this.setTinhTrang( ch.getTinhTrang());
    }

}
