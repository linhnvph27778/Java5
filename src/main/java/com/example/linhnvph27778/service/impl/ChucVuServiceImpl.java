package com.example.linhnvph27778.service.impl;

import com.example.linhnvph27778.model.ChucVu;
import com.example.linhnvph27778.repository.ChucVuRepository;
import com.example.linhnvph27778.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public Optional<ChucVu> getById(UUID id) {
        return chucVuRepository.findById(id);
    }

    @Override
    public void delete(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public Page<ChucVu> phanTrang(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo,size);
        return chucVuRepository.findAll(pageable);
    }
}
