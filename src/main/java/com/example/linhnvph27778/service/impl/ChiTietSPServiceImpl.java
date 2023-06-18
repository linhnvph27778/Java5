package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.ChiTietSanPham;
import com.example.linhnvph27778.repository.ChiTietSPRepository;
import com.example.linhnvph27778.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"soLuongTon");
        return chiTietSPRepository.findAll(sort);
    }

    @Override
    public Optional<ChiTietSanPham> getById(UUID id) {
        return chiTietSPRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        chiTietSPRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(ChiTietSanPham chiTietSanPham) {
        chiTietSPRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return chiTietSPRepository.getReferenceById(id);
    }

    @Override
    public Page<ChiTietSanPham> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return chiTietSPRepository.findAll(pageable);
    }


}
