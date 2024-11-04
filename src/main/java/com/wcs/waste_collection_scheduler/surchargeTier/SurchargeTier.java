package com.wcs.waste_collection_scheduler.surchargeTier;

import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import com.wcs.waste_collection_scheduler.wasteCollectionProgram.WasteCollectionProgram;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SurchargeTier extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minExtraCollections; // Minimum de passages supplémentaires pour ce palier
    private int maxExtraCollections; // Maximum de passages supplémentaires pour ce palier
    private double surchargePercentage; // Pourcentage de majoration pour ce palier

    @ManyToOne
    @JoinColumn(name = "waste_collection_program_id")
    private WasteCollectionProgram wasteCollectionProgram;
}
