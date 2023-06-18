package com.example.linhnvph27778.viewmodel;

import com.example.linhnvph27778.model.ChiTietSanPham;
import com.example.linhnvph27778.model.HoaDon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChiTietSanPhamVm {
    private int soLuongTon;

    public void loadFromEntity(ChiTietSanPham ctsp)
    {
     this.setSoLuongTon(ctsp.getSoLuongTon());

    }


}
