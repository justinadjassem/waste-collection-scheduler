package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.citizen.Citizen;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
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
    private String longitude;
    private String latitude;
    private Long numberOfCitizen;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    private Citizen citizen;
}
