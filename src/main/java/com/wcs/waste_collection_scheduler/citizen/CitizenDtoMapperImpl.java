package com.wcs.waste_collection_scheduler.citizen;

import com.wcs.waste_collection_scheduler.utils.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class CitizenDtoMapperImpl {
    private final GenericMapper genericMapper;

    public CitizenDtoMapperImpl(GenericMapper genericMapper) {
        this.genericMapper = genericMapper;
    }

    public CitizenDTO toDto(Citizen citizen) {
        return genericMapper.map(citizen, CitizenDTO.class);
    }
    public Citizen toEntity(CitizenDTO citizenDTO) {
        return genericMapper.map(citizenDTO, Citizen.class);
    }
}
