package com.magch.randevu.domain.models.enums;

public enum UserRoleEnum {
    SUPER_ADMIN("Super Admin", 0), // Tüm güncellemeleri yapabilir
    ADMIN("Admin", 1), // Tüm işletme bilgileri güncelleyebilir Kullanıcılar ile ilgili tüm ekleme göncelleme işlemini yapar
    MANAGER_("Manager_", 2), // Ürünle ile ilgili tüm ekleme ve güncellemeleri yapabilir Kullanıcılar ile ilgili tüm ekleme göncelleme işlemini yapar.
    MANAGER("Manager", 3), // Kullanıcılar ile ilgili tüm ekleme göncelleme işlemini yapar.
    EMPLOYEE_("Employee_", 4), // Sadece kendi bilgilerini güncelleyebilir
    EMPLOYEE("Employee", 5); // Kimsenin bilgisini güncelleyemez

    private final String roleName;
    private final int order;

    UserRoleEnum(String roleName, int order) {
        this.roleName = roleName;
        this.order = order;
    }

    public String getRoleName() {
        return roleName;
    }

    public int getOrder() {
        return order;
    }

    public boolean canManageUsers() {
        return this.order <= 3;
    }

    public boolean canManageProducts() {
        return this.order <= 2;
    }

    public boolean canManageBusiness() {
        return this.order <= 1;
    }

    public boolean canManageAllOperations() {
        return this.order == 0;
    }

    public boolean canUpdateOwnInfo() {
        return this.order <= 4;
    }

    public boolean hasHigherOrEqualAuthority(UserRoleEnum otherRole) {
        return this.order <= otherRole.order;
    }
}
