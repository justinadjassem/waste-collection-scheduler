package com.wcs.waste_collection_scheduler.wastCollection;

import com.wcs.waste_collection_scheduler.enums.CollectionStatus;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WasteCollection extends BaseEntity<Long> implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CollectionStatus collectionStatus;
    private Instant collectionDate;
    private Boolean isValidatedByClient;
    private Boolean isValidatedByCollector;
}
