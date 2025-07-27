package com.magch.randevu.domain.business.mapper;


import com.magch.randevu.domain.business.dto.BusinessDto;
import com.magch.randevu.domain.business.entity.BusinessEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusinessMapper {
    BusinessMapper INSTANCE = Mappers.getMapper(BusinessMapper.class);

    @Mapping(target = "talentId", ignore = true)
    BusinessEntity toEntity(BusinessDto businessDto);

    BusinessDto toDto(BusinessEntity businessEntity);

    @Mapping(source = "businessDto.name", target = "name")
    @Mapping(source = "businessDto.surname", target = "surname")
    @Mapping(source = "businessDto.shopName", target = "shopName")
    @Mapping(source = "businessDto.city", target = "city")
    @Mapping(source = "businessDto.district", target = "district")
    @Mapping(source = "businessDto.addressDetail", target = "addressDetail")
    @Mapping(source = "businessDto.category", target = "category")
    @Mapping(source = "businessDto.phoneNumber", target = "phoneNumber")
    @Mapping(source = "businessDto.website", target = "website")
    @Mapping(source = "businessDto.taxNumber", target = "taxNumber")
    @Mapping(target = "talentId", ignore = true)
    BusinessEntity updateEntity(@MappingTarget BusinessEntity businessEntity, BusinessDto businessDto);
}
