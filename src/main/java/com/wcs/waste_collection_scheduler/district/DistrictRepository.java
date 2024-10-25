package com.wcs.waste_collection_scheduler.district;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findByName(String name);
    Optional<District> findByIdAndDeletedFalse(Long id);
    boolean existsByIdAndDeletedFalse(Long id);
}
