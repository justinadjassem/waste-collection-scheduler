package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.citizen.CitizenNotFoundException;

import java.util.List;

public interface HomeService {
    HomeDTO getHome(Long id) throws HomeNotFoundException;
    HomeDTO createHome(HomeDTO home);
    HomeDTO updateHome(HomeDTO home) throws CitizenNotFoundException, HomeNotFoundException;
    void homeLogicalDeletion(Long id) throws HomeNotFoundException;
    List<HomeDTO> getAllHome();
}
