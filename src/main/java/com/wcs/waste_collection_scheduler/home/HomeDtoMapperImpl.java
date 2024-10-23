package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.utils.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class HomeDtoMapperImpl {
    private final GenericMapper genericMapper;

    public HomeDtoMapperImpl(GenericMapper genericMapper) {
        this.genericMapper = genericMapper;
    }

    public HomeDTO toDto(Home home) {
        return genericMapper.map(home, HomeDTO.class);
    }
    public Home toEntity(HomeDTO homeDTO) {
        return genericMapper.map(homeDTO, Home.class);
    }
}
