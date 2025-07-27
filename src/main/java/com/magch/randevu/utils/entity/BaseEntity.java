package com.magch.randevu.utils.entity;
import com.magch.randevu.domain.models.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    private static final SnowflakeIdGenerator ID_GENERATOR = new SnowflakeIdGenerator(1);

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    
    public Long getId() {
        return id;
    }

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 50)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status = Status.ACTIVE;

    @PrePersist
    public void prePersist() {
        if (id == null) {
            id = ID_GENERATOR.nextId();
        }
    }
}
