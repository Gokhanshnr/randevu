package com.magch.randevu.domain.business.repository;

import com.magch.randevu.domain.business.entity.UserEntity;
import com.magch.randevu.domain.models.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByBusinessId(Long businessId);
    
    boolean existsByBusinessIdAndRole(Long businessId, UserRoleEnum role);
    
    long countByBusinessId(Long businessId);
    
    Optional<UserEntity> findByBusinessIdAndRole(Long businessId, UserRoleEnum role);

}