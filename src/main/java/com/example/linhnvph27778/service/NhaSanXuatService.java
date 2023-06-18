package com.example.linhnvph27778.service;

import com.example.linhnvph27778.model.MauSac;
import com.example.linhnvph27778.model.NhaSanXuat;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhaSanXuatService {
    List<NhaSanXuat> getAll();

    Optional<NhaSanXuat> getById(UUID id);

    void delete(UUID id);

    void saveOrUpdate(NhaSanXuat nhaSanXuat);

    Page<NhaSanXuat> phanTrang(Integer pageNo, Integer size);
}
