package com.magch.randevu.domain.business.mapper;


import com.magch.randevu.domain.business.dto.BusinessDto;
import com.magch.randevu.domain.business.entity.BusinessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessMapper INSTANCE = Mappers.getMapper(BusinessMapper.class);

    @Mapping(target = "talentId", ignore = true)
    BusinessEntity toEntity(BusinessDto businessDto);

    BusinessDto toDto(BusinessEntity businessEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "talentId", ignore = true)
    BusinessEntity toEntity(BusinessDto businessDto, BusinessEntity businessEntity);
}
