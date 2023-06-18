package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.NhaSanXuat;
import com.example.linhnvph27778.repository.NhaSanXuatRepository;
import com.example.linhnvph27778.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;
    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public Optional<NhaSanXuat> getById(UUID id) {
        return nhaSanXuatRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        nhaSanXuatRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public Page<NhaSanXuat> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return nhaSanXuatRepository.findAll(pageable);
    }
}
