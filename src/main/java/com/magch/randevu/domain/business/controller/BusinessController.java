package com.magch.randevu.domain.business.controller;

import com.magch.randevu.domain.business.dto.BusinessDto;
import com.magch.randevu.domain.business.services.BusinessService;
import com.magch.randevu.domain.models.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/business")
@RequiredArgsConstructor
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping("/save")
    public BaseResponse<Long> saveBusiness(@RequestBody BusinessDto request) {
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
