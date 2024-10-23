package com.wcs.waste_collection_scheduler.home;

import java.util.List;

public interface HomeService {
    HomeDTO getHome(Long id);
    HomeDTO createHome(HomeDTO home);
    HomeDTO updateHome(HomeDTO home);
    HomeDTO homeLogicalDeletion(Long id);
    List<HomeDTO> getAllHome();
}
