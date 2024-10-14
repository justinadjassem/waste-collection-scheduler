package com.wcs.waste_collection_scheduler.citizen;

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
@RequestMapping("/citizen")
@Tag(name = "Citizen")
public class CitizenRestController {
    private final CitizenService citizenService;

    @PostMapping
    CitizenDTO createCitizen(@Valid @RequestBody CitizenDTO citizen) {
        return citizenService.createCitizen(citizen);
    }
    @GetMapping("/{id}")
    ResponseEntity<CitizenDTO> getCitizen(@PathVariable long id) throws CitizenNotFoundException {
        CitizenDTO citizenDTO = citizenService.getCitizen(id);
        return ResponseEntity.ok(citizenDTO);
    }

    @PutMapping("/{id}")
    CitizenDTO updateCitizen(@PathVariable long id,@Valid @RequestBody CitizenDTO citizen) throws CitizenNotFoundException {
        citizen.setId(id);
        return citizenService.updateCitizen(citizen);
    }
    @GetMapping
    List<CitizenDTO> getCitizens() {
        return citizenService.getAllCitizens();
    }
    @DeleteMapping("/{id}")
    void deleteCitizen(@PathVariable long id) throws CitizenNotFoundException {
        citizenService.citizenLogicalDeletion(id);
    }

}
