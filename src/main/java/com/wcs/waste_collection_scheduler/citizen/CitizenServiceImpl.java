package com.wcs.waste_collection_scheduler.citizen;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CitizenServiceImpl implements CitizenService {
    private CitizenRepository citizenRepository;
    private CitizenDtoMapperImpl citizenDtoMapper;
    @Override
    public CitizenDTO createCitizen(CitizenDTO citizenDTO) {
        Citizen citizen = citizenDtoMapper.toEntity(citizenDTO);
        log.info("Registation of a new citizen : {}", citizen.getEmail());
        try{
            Citizen CreatedCitizen = citizenRepository.save(citizen);
            return citizenDtoMapper.toDto(CreatedCitizen);
        } catch (Exception e) {
            log.error("Error creating citizen : {}", e.getMessage());
            throw new RuntimeException("Error creating citizen",e);
        }
    }

    @Override
    public CitizenDTO updateCitizen(CitizenDTO citizen) throws CitizenNotFoundException {
        if (citizenRepository.existsByIdAndDeletedFalse(citizen.getId())){
            Citizen citizenEntity = citizenDtoMapper.toEntity(citizen);

            log.info("Updating citizen with email : {}", citizen.getEmail());
            return citizenDtoMapper.toDto(citizenRepository.save(citizenEntity));
        }
        throw new CitizenNotFoundException("Citizen with id "+ citizen.getId() +" not found");
    }

    @Override
    public void citizenLogicalDeletion(Long id) throws CitizenNotFoundException {
        log.info("Deleting a Citizen : {}", id);
        Citizen citizen = citizenRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new CitizenNotFoundException("Citizen with id "+ id +" not found"));
        citizen.delete();
        citizenRepository.save(citizen);
    }

    @Override
    public CitizenDTO getCitizen(Long id) throws CitizenNotFoundException {
        log.info("Retrieving a Citizen : {}", id);

        Citizen citizen = citizenRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new CitizenNotFoundException("A citizen with id " + id + " was not found."));
        return citizenDtoMapper.toDto(citizen);

    }

    @Override
    public List<CitizenDTO> getAllCitizens() {
        log.info("Retrieving all citizens");
        List<Citizen> citizens = citizenRepository.findAll();
        return citizens.stream()
                .filter(citizen -> !citizen.isDeleted())
                .map(citizen -> citizenDtoMapper.toDto(citizen))
                .collect(Collectors.toList());
    }
}
