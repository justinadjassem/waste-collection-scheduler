package com.wcs.waste_collection_scheduler.district;

import com.wcs.waste_collection_scheduler.utils.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class DistrictDtoMapperImpl {
    private final GenericMapper genericMapper;

    public DistrictDtoMapperImpl(GenericMapper genericMapper) {
        this.genericMapper = genericMapper;
    }

    public DistrictDTO toDto(District district) {
        return genericMapper.map(district, DistrictDTO.class);
    }
    public District toEntity(DistrictDTO districtDTO) {
        return genericMapper.map(districtDTO, District.class);
    }
}
