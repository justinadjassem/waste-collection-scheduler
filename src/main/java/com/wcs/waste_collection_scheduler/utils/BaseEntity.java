package com.wcs.waste_collection_scheduler.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "createdBy", "updatedAt", "updatedBy"})
public abstract class BaseEntity<T> implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true, updatable = false)
    @CreatedDate
    private Instant createdAt = Instant.now();
//    @CreatedBy
//    @Column(name = "created_by", nullable = true, updatable = false)
//    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();
//    @LastModifiedBy
//    @Column(name = "updated_by")
//    private String updatedBy;

    private boolean deleted = false;
    private Instant deletedAt;
    public abstract T getId();
    // Méthodes pour gérer la suppression logique
    public void delete() {
        this.deleted = true;
        this.deletedAt = Instant.now();
    }
    // Méthodes pour restaurer une suppression logique
    public void restore() {
        this.deleted = false;
        this.deletedAt = null;
    }

}
