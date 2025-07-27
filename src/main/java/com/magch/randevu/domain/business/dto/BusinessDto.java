package com.magch.randevu.domain.business.dto;

import com.magch.randevu.domain.models.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessDto {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Shop name cannot be blank")
    private String shopName;

    @NotBlank(message = "City cannot be blank")
    private String city;

    @NotBlank(message = "District cannot be blank")
    private String district;

    @NotBlank(message = "Address detail cannot be blank")
    private String addressDetail;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Web address cannot be blank")
    private String website;

    @NotBlank(message = "Tax number cannot be blank")
    private String taxNumber;

    @NotBlank(message = "Tax office cannot be blank")
    private Status status;
}
