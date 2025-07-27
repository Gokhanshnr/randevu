package com.magch.randevu.domain.business.entity;

import com.magch.randevu.domain.models.WorkScheduleModel;
import com.magch.randevu.domain.models.enums.UserRoleEnum;
import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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
    private UserRoleEnum role;
    private String password;
    private String token;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "work_schedule", columnDefinition = "jsonb")
    private WorkScheduleModel workSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private BusinessEntity business;
}
