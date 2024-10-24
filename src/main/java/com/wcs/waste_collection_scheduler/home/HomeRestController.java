package com.wcs.waste_collection_scheduler.home;

import com.wcs.waste_collection_scheduler.citizen.CitizenNotFoundException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/home")
@Tag(name = "Home")
public class HomeRestController {
    private final HomeService homeService;

    @PostMapping
    HomeDTO createHome(@Valid @RequestBody HomeDTO homeDTO) {
        return homeService.createHome(homeDTO);
    }
    @GetMapping("/{id}")
    HomeDTO getHome(@PathVariable Long id) throws HomeNotFoundException {
        HomeDTO homeDTO = homeService.getHome(id);
        return ResponseEntity.ok(homeDTO).getBody();
    }
    @GetMapping
    List<HomeDTO> getHomes() {
        return homeService.getAllHome();
    }
    @PutMapping("/{id}")
    HomeDTO updateHome(@PathVariable Long id, @Valid @RequestBody HomeDTO homeDTO) throws HomeNotFoundException, CitizenNotFoundException {
        homeDTO.setId(id);
        return homeService.updateHome(homeDTO);
    }
    @DeleteMapping("/{id}")
    void deleteHome(@PathVariable Long id) throws HomeNotFoundException {
        homeService.homeLogicalDeletion(id);
    }
}

