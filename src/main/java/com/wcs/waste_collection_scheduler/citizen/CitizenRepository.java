package com.wcs.waste_collection_scheduler.citizen;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    Optional<Citizen> findByEmail(String email);
    Optional<Citizen> findByIdAndDeletedFalse(Long id);
    boolean existsByIdAndDeletedFalse(Long id);
}
