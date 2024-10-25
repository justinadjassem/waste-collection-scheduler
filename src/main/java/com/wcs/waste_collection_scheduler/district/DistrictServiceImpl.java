package com.wcs.waste_collection_scheduler.district;

import com.wcs.waste_collection_scheduler.home.HomeDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DistrictServiceImpl implements DistrictService {
    @Override
    public HomeDTO getDistrict(Long id) {
        return null;
    }

    @Override
    public HomeDTO createDistrict(HomeDTO home) {
        return null;
    }

    @Override
    public HomeDTO updateDistrict(HomeDTO home) {
        return null;
    }

    @Override
    public void districtLogicalDeletion(Long id) {

    }

    @Override
    public List<HomeDTO> getAllDistrict() {
        return List.of();
    }
}
