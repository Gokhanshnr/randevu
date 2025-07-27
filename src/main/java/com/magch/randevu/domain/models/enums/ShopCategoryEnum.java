package com.magch.randevu.domain.models.enums;

public enum ShopCategoryEnum {
    BERBER("Berber"),
    KUAFOR("Kuaför"),
    HALISAHA("Halı Saha");

    private final String displayName;
    ShopCategoryEnum(String displayName) {
        this.displayName = displayName;
    }
}
