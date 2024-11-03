package com.wcs.waste_collection_scheduler.company;

import com.wcs.waste_collection_scheduler.member.Member;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Company extends BaseEntity<Long> implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    List<Member> listOfMembers; // Membres associés à la compagnie
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
    List<Team> listOfTeams; // Équipes associées à la compagnie

}
