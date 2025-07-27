package com.magch.randevu.domain.website.entity;

import com.magch.randevu.utils.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.GeoModule;

@Entity
@Table(name = "web_settings")
@Getter
@Setter
public class WebSettingsEntity extends BaseEntity {



    @Column(name = "theme", length = 50)
    private Integer theme= 1;

    @Column(name = "logo", length = 255)
    private String logoUrl;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "background_image", length = 255)
    private String backgroundImageUrl;

    @Column(name = "info_text", length = 255)
    private String infoText;

    @Column(name = "contact_number", length = 20)
    private String contactNumber;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "instagram", length = 100)
    private String instagramUrl;

    @Column(name = "facebook", length = 100)
    private String facebookUrl;

    @Column(name = "whatsapp", length = 100)
    private String whatsappUrl;

    @Column(name = "map_location", length = 255)
    private GeoModule mapLocation;

}
