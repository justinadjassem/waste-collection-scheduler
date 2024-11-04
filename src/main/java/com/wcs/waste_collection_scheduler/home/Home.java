package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.citizen.Citizen;
import com.wcs.waste_collection_scheduler.district.District;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import com.wcs.waste_collection_scheduler.wasteCollectionProgram.WasteCollectionProgram;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Home extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private double longitude;
    private double latitude;
    private Long numberOfCitizen;
    @ManyToOne
    @JoinColumn(name = "waste_collection_program_id")
    private WasteCollectionProgram wasteCollectionProgram;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    private Citizen houseManager;
    @ManyToOne(cascade = CascadeType.ALL)
    private District district;
}
