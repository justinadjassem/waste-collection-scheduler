package com.wcs.waste_collection_scheduler.home;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HomeRepository extends JpaRepository<Home, Long> {
    Optional<Home> findByName(String name);
    Optional<Home> findByIdAndDeletedFalse(Long id);
    boolean existsByIdAndDeletedFalse(Long id);
}
