package com.magch.randevu.domain.business.repository;


import com.magch.randevu.domain.business.entity.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, Long> {
    BusinessEntity findByName(String name);

    Optional<BusinessEntity> findByWebAddress(String webAddress);

    boolean existsByWebsite(String webAddress);
}
