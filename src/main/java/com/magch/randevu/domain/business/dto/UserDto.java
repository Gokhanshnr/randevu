package com.magch.randevu.domain.business.dto;

import com.magch.randevu.domain.models.WorkScheduleModel;
import com.magch.randevu.domain.models.enums.Status;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    private String photoUrl;

    private String title;

    private String about;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @NotBlank(message = "Role cannot be blank")
    private String role;

    private String password;

    private String token;

    @Valid
    private WorkScheduleModel workSchedule;
}