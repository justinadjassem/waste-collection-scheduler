package com.wcs.waste_collection_scheduler.district;

import com.wcs.waste_collection_scheduler.home.HomeDTO;

import java.util.List;

public interface DistrictService {
    HomeDTO getDistrict(Long id);
    HomeDTO createDistrict(HomeDTO home);
    HomeDTO updateDistrict(HomeDTO home);
    void districtLogicalDeletion(Long id);
    List<HomeDTO> getAllDistrict();
}
