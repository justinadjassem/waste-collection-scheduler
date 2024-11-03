package com.wcs.waste_collection_scheduler.wasteCollectionProgram;

import com.wcs.waste_collection_scheduler.enums.CollectionStatus;
import com.wcs.waste_collection_scheduler.enums.ProgramFrequency;
import com.wcs.waste_collection_scheduler.home.Home;
import com.wcs.waste_collection_scheduler.pricing.Pricing;
import com.wcs.waste_collection_scheduler.team.Team;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WasteCollectionProgram extends BaseEntity<Long> implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String Calendar;
    private ProgramFrequency frequency;
    private Long numberOfDays;
    private CollectionStatus status;
    @ManyToOne
    @JoinColumn(name = "id")
    private Home home;
    @ManyToOne
    @JoinColumn(name = "id")
    private Team team;
    private Pricing pricing;
}
