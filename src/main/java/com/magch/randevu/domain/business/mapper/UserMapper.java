package com.magch.randevu.domain.business.mapper;

import com.magch.randevu.domain.business.dto.UserDto;
import com.magch.randevu.domain.business.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}