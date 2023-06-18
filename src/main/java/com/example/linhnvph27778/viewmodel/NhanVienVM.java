package com.example.linhnvph27778.viewmodel;

import com.example.linhnvph27778.model.ChucVu;
import com.example.linhnvph27778.model.CuaHang;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class NhanVienVM {
    private String id;
    @NotBlank(message = "Không được bỏ trống")
    private String ten;

    @NotBlank(message = "Không được bỏ trống")
    private String matKhau;


}
