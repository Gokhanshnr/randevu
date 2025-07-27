package com.magch.randevu.domain.business.services;

import com.magch.randevu.domain.business.entity.BusinessEntity;
import com.magch.randevu.domain.business.entity.UserEntity;

import com.magch.randevu.domain.business.repository.UserRepository;
import com.magch.randevu.domain.models.enums.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity saveSuperAdmin(UserEntity user, BusinessEntity business) {

    }

    @Transactional
    public UserEntity saveUser(UserEntity user, UserRoleEnum requestedRole, Long businessId) {
        if (requestedRole == UserRoleEnum.SUPER_ADMIN) {
            throw new IllegalArgumentException("Super Admin can only be created through saveSuperAdmin method");
        }
        
        BusinessEntity business = new BusinessEntity();
        business.setId(businessId);
        user.setBusiness(business);
        user.setRole(requestedRole);
        
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> getAllByBusinessId(Long businessId) {
        return userRepository.findByBusinessId(businessId);
    }
    
    public boolean canUserPerformAction(UserRoleEnum userRole, UserRoleEnum requiredRole) {
        return userRole.hasHigherOrEqualAuthority(requiredRole);
    }


}