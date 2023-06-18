package com.example.linhnvph27778.model;

import com.example.linhnvph27778.viewmodel.HoaDonVM;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity(name = "HoaDon")
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class HoaDon {
    @Id
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "ngaytao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "ngaythanhtoan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayThanhToan;

    @Column(name = "ngayship")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayShip;

    @Column(name = "ngaynhan")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayNhan;

    @Column(name = "tinhtrang")
    private int tinhTrang;

    @Column(name = "tennguoinhan")
    private String tenNguoiNhan;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sdt")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "idkh")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "idnv")
    private NhanVien nhanVien;

    public void loadFromVM(HoaDonVM vm)
    {
        this.setMa( vm.getMa() );
        this.setTinhTrang( vm.getTinhTrang() );
        this.setNgayTao( vm.getNgayTao() );
    }
}
