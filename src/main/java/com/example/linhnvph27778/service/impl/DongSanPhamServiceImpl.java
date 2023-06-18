package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.DongSanPham;
import com.example.linhnvph27778.repository.DongSanPhamRepository;
import com.example.linhnvph27778.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAll() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public Optional<DongSanPham> getById(UUID id) {
        return dongSanPhamRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public Page<DongSanPham> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return dongSanPhamRepository.findAll(pageable);
    }
}
