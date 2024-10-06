package com.wcs.waste_collection_scheduler.citizen;

import java.util.List;

public interface CitizenService {
    CitizenDTO createCitizen(CitizenDTO citizen);
    CitizenDTO updateCitizen(CitizenDTO citizen);
    void deleteCitizen(Long id);
    CitizenDTO getCitizen(Long id) throws CitizenNotFoundException;
    List<CitizenDTO> getAllCitizens();
}
