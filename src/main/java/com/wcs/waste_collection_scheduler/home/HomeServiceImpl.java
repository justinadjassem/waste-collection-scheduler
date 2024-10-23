package com.wcs.waste_collection_scheduler.home;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j

public class HomeServiceImpl implements HomeService {
    private HomeRepository homeRepository;
    private HomeDtoMapperImpl homeDtoMapper;
    @Override
    public HomeDTO getHome(Long id) {
        log.info("Retrieving a home : {}", id);
        Home home = homeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new HomeNotFoundException("A home with id " + id + " was not found."));
        return homeDtoMapper.toDto(home);
    }

    @Override
    public HomeDTO createHome(HomeDTO homeDTO) {
        Home home = homeDtoMapper.toEntity( homeDTO);
        log.info("saving of a new home : {}", home.getName());
        try{
            Home savedHome = homeRepository.save(home);
            return homeDtoMapper.toDto(savedHome);
        }catch(Exception e){
            log.error("Error creating home : {}", e.getMessage());
            throw new RuntimeException("Error creating home",e);
        }
    }

    @Override
    public HomeDTO updateHome(HomeDTO home) {
        if (homeRepository.existsByIdAndDeletedFalse(home.getId())) {
            Home homeToUpdate = homeDtoMapper.toEntity(home);
            log.info("Updating citizen with name : {}", home.getName());
            return homeDtoMapper.toDto(homeRepository.save(homeToUpdate));
        }
        throw  new HomeNotFoundException("home with id "+ home.getId() +" not found");
    }

    @Override
    public HomeDTO homeLogicalDeletion(Long id) {
        return null;
    }

    @Override
    public List<HomeDTO> getAllHome() {
        return List.of();
    }
}
