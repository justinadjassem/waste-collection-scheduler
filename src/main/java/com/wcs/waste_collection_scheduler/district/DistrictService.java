package com.wcs.waste_collection_scheduler.district;

import java.util.List;

public interface DistrictService {
    DistrictDTO getDistrict(Long id) throws DistrictNotFoundException;
    DistrictDTO createDistrict(DistrictDTO district);
    DistrictDTO updateDistrict(DistrictDTO district) throws DistrictNotFoundException;
    void districtLogicalDeletion(Long id) throws DistrictNotFoundException;
    List<DistrictDTO> getAllDistrict();
}
