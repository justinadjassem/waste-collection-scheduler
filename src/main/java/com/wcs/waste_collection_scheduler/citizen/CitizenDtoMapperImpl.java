package com.wcs.waste_collection_scheduler.citizen;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CitizenDtoMapperImpl {
    public CitizenDTO toDto(Citizen citizen) {
        CitizenDTO citizenDTO = new CitizenDTO();
        BeanUtils.copyProperties(citizen, citizenDTO);
        return citizenDTO;
    }
    public Citizen toEntity(CitizenDTO citizenDTO) {
        Citizen citizen = new Citizen();
        BeanUtils.copyProperties(citizenDTO, citizen);
        return citizen;
    }
}
