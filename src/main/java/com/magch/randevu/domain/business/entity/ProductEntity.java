package com.magch.randevu.domain.business.entity;

import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
public class ProductEntity extends BaseEntity {

    private String name;
    private Double price;
    private String description;
    private LocalTime duration;
}
