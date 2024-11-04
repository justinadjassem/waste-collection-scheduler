package com.wcs.waste_collection_scheduler.team;

import com.wcs.waste_collection_scheduler.company.Company;
import com.wcs.waste_collection_scheduler.member.Member;
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
public class Team extends BaseEntity<Long> implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int numberOfMember;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company; // Compagnie de ramassage associée
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "team")
    List<Member> listOfMembers; // Membres assignés à l'équipe
}
