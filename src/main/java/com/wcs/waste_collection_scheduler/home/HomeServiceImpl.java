package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.citizen.CitizenNotFoundException;
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
public class HomeServiceImpl implements HomeService {
    private HomeRepository homeRepository;
    private HomeDtoMapperImpl homeDtoMapper;
    @Override
    public HomeDTO getHome(Long id) throws HomeNotFoundException {
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
    public HomeDTO updateHome(HomeDTO home) throws CitizenNotFoundException, HomeNotFoundException {
        if (homeRepository.existsByIdAndDeletedFalse(home.getId())) {
            Home homeToUpdate = homeDtoMapper.toEntity(home);
            log.info("Updating citizen with name : {}", home.getName());
            return homeDtoMapper.toDto(homeRepository.save(homeToUpdate));
        }
        throw  new HomeNotFoundException("home with id "+ home.getId() +" not found");
    }

    @Override
    public void homeLogicalDeletion(Long id) throws HomeNotFoundException {
        Home home = homeRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new HomeNotFoundException("No house exists with the id " + id + "please check your entries"));
        home.delete();
        homeRepository.save(home);
    }

    @Override
    public List<HomeDTO> getAllHome() {
        log.info("Retrieving all home");
        List<Home> homes = homeRepository.findAll();
        return homes.stream()
                .filter(home -> !home.isDeleted())
                .map(home -> homeDtoMapper.toDto(home))
                .collect(Collectors.toList());
    }
}
