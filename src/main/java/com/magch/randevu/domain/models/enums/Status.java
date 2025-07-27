package com.magch.randevu.domain.models.enums;

public enum Status {
    ACTIVE("Aktif"),
    PASSIVE("Pasif"),
    DELETED("Silinmiş");

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
