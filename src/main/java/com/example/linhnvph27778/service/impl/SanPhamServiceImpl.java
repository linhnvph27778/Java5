package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.SanPham;
import com.example.linhnvph27778.repository.SanPhamRepository;
import com.example.linhnvph27778.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<SanPham> getById(UUID id) {
        Optional<SanPham> sanPham = sanPhamRepository.findById(id);
        return sanPham;
    }

    @Override
    public void delete(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public Page<SanPham> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public Page<SanPham> timKiem(String keyword, Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return sanPhamRepository.search(keyword,pageable);
    }


}
