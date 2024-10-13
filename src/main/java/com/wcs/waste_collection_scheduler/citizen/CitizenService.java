package com.wcs.waste_collection_scheduler.citizen;

import java.util.List;

public interface CitizenService {
    CitizenDTO createCitizen(CitizenDTO citizen);
    CitizenDTO updateCitizen(CitizenDTO citizen) throws CitizenNotFoundException;
    void citizenLogicalDeletion(Long id) throws CitizenNotFoundException;
    CitizenDTO getCitizen(Long id) throws CitizenNotFoundException;
    List<CitizenDTO> getAllCitizens();
}
