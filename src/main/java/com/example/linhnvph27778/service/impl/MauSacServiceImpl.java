package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.MauSac;
import com.example.linhnvph27778.model.SanPham;
import com.example.linhnvph27778.repository.MauSacRepository;
import com.example.linhnvph27778.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public Optional<MauSac> getById(UUID id) {
        Optional<MauSac> mauSac = mauSacRepository.findById(id);
        return mauSac;
    }

    @Override
    public void delete(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(MauSac sanPham) {
        mauSacRepository.save(sanPham);
    }

    @Override
    public Page<MauSac> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return mauSacRepository.findAll(pageable);
    }
}
