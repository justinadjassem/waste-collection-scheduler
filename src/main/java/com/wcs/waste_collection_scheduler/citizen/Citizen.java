package com.wcs.waste_collection_scheduler.citizen;

import com.wcs.waste_collection_scheduler.home.Home;
import com.wcs.waste_collection_scheduler.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "citizen",indexes = @Index(columnList = "email"))
public class Citizen extends BaseEntity<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    @OneToOne(mappedBy = "citizen")
    private Home home;
}
