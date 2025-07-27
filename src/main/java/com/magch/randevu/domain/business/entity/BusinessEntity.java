package com.magch.randevu.domain.business.entity;

import com.magch.randevu.domain.models.enums.ShopCategoryEnum;
import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "business")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BusinessEntity extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "talent_id", nullable = false, unique = true)
    private Integer talentId;

    @NotNull
    @Size(max = 50)
    @Column(name = "first_name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    @Column(name = "last_name", nullable = false, length = 50)
    private String surname;

    @NotNull
    @Size(max = 100)
    @Column(name = "shop_name", nullable = false, length = 100)
    private String shopName;

    @NotNull
    @Size(max = 100)
    @Column(name = "address", nullable = false, length = 100)
    private String city;

    @Size(max = 50)
    @Column(name = "district", length = 50)
    @NotNull
    private String district;

    @Size(max = 255)
    @Column(name = "addres_detail", length = 255)
    private String addressDetail;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 30)
    private ShopCategoryEnum category;

    @Size(max = 20)
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Size(min = 3, max = 100)
    @Column(name = "website", length = 100)
    private String website;

    @Size(max = 20)
    @Column(name = "tax_number", length = 20, unique = true)
    private String taxNumber;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        BusinessEntity that = (BusinessEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
