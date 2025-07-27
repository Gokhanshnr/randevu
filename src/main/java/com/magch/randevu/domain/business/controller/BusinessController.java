package com.magch.randevu.domain.business.controller;

import com.magch.randevu.domain.business.dto.BusinessDto;
import com.magch.randevu.domain.business.services.BusinessService;
import com.magch.randevu.domain.models.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    private final BusinessService businessService;
    
    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PostMapping("/save")
    public BaseResponse<Long> saveBusiness(@Valid @RequestBody BusinessDto request) {
        return BaseResponse.ok(businessService.saveOrUpdate(request));
    }

    @PostMapping("/get/{id}")
    public BaseResponse<BusinessDto> getBusinessById(@PathVariable String id) {
        try {
            Long businessId = Long.parseLong(id);
            return BaseResponse.ok(businessService.findById(businessId));
        } catch (NumberFormatException e) {
            return BaseResponse.ok(businessService.findByWebName(id));
        }
    }

    @PostMapping("/isWebAddressUsed")
    public BaseResponse<Boolean> isWebAddressUsed(String webAddress) {
        return BaseResponse.ok(businessService.isWebAddressUsed(webAddress));
    }

}
