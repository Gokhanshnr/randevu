package com.magch.randevu.domain.business.entity;

import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    private String name;
    private String surname;
    private String photoUrl;
    private String title;
    private String about;
    private String phoneNumber;
    private String role;
    private String password;
    private LocalTime startTime;
    private LocalTime endTime;
    private String token;

    private Boolean canCancelAppointmentWithoutPermission;
    private Boolean canApproveAppointment;
    private Boolean canApproveAppointmentCancellation;
    private Boolean canTakeLeaveWithoutPermission;
    private Boolean canApproveLeaveRequests;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkScheduleEntity> workSchedules;

}
