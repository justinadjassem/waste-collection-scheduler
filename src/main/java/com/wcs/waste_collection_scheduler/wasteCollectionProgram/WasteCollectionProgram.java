package com.wcs.waste_collection_scheduler.wasteCollectionProgram;

import com.wcs.waste_collection_scheduler.enums.CollectionStatus;
import com.wcs.waste_collection_scheduler.enums.ProgramFrequency;
import com.wcs.waste_collection_scheduler.home.Home;
import com.wcs.waste_collection_scheduler.surchargeTier.SurchargeTier;
import com.wcs.waste_collection_scheduler.team.Team;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

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
    @ElementCollection
    private List<String> daysOfCollection;
    private String Calendar;
    private ProgramFrequency frequency;
    private double standardPrice;
    private Long includedCollections;
    // Liste des paliers de majoration pour le programme
    @OneToMany(mappedBy = "wasteCollectionProgram", cascade = CascadeType.ALL)
    private List<SurchargeTier> surchargeTiers;
    private Long numberOfDays;
    private CollectionStatus status;
    @OneToMany(mappedBy = "wasteCollectionProgram", cascade = CascadeType.ALL)
    private List<Home> home;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
