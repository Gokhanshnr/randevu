package com.magch.randevu.domain.business.entity;

import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
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

    /*
    Mola Saatleri
Her x Dakikada Randevu
Galeri (İşlem Kişi)

İzinsiz Randevu İptal edebilsin
Randevuları onaylayabilsin
Randevu İptal Etme İşlemini Onaylıyabilsin
İzinsiz izin girebilsin
İzin isteklerini onaylayabilsin
İzinsiz randevuyu başka kişinin üzerine atabilsin
Randevu atma işlemini onaylayabilsin
     */

    private Boolean canCancelAppointmentWithoutPermission;
    private Boolean canApproveAppointment;
    private Boolean canApproveAppointmentCancellation;
    private Boolean canTakeLeaveWithoutPermission;
    private Boolean canApproveLeaveRequests;

}
