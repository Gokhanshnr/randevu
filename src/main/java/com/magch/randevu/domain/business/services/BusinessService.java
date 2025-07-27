package com.magch.randevu.domain.business.services;

import com.magch.randevu.domain.business.dto.BusinessDto;
import com.magch.randevu.domain.business.entity.BusinessEntity;
import com.magch.randevu.domain.business.mapper.BusinessMapper;
import com.magch.randevu.domain.business.repository.BusinessRepository;

import com.magch.randevu.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BusinessService {

    private final BusinessRepository repository;
    private final BusinessMapper mapper = BusinessMapper.INSTANCE;

    public Long saveOrUpdate(BusinessDto dto) {
        BusinessEntity entity = dto.getId() == null
                ? mapper.toEntity(dto)
                : repository.findById(dto.getId())
                .map(existing -> mapper.toEntity(dto, existing))
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Business not found with id: " + dto.getId()));

        return repository.save(entity).getId();
    }

    @Transactional(readOnly = true)
    public BusinessDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Business not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public BusinessDto findByWebName(String webName) {
        return repository.findByWebAddress(webName)
                .map(mapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Business not found with web name: " + webName));
    }

    @Transactional(readOnly = true)
    public boolean isWebAddressUsed(String webAddress) {
        return repository.existsByWebsite(webAddress);
    }
}
