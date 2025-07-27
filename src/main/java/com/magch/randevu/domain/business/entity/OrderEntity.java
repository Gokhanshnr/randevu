package com.magch.randevu.domain.business.entity;

import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.Entity;


@Entity
public class OrderEntity extends BaseEntity {
    private Long talentId;
    private Long businessId;
    private Long productId;
    private Long userId;

    private String status; // Ödeme durumu, örneğin "Ödeme Bekleniyor", "Ödeme Tamamlandı", "İptal Edildi" gibi
    private String paymentMethod; // Ödeme yöntemi, örneğin "Kredi Kartı", "Nakit", "Havale" gibi
    private Double amount;
    private String currency = "TRY";

}
