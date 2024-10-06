package com.wcs.waste_collection_scheduler.citizen;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    CitizenDTO createCitizen(@RequestBody CitizenDTO citizen) {

        return citizenService.createCitizen(citizen);
    }
    @GetMapping("/{id}")
    CitizenDTO getCitizen(@PathVariable long id) throws CitizenNotFoundException {

        return citizenService.getCitizen(id);
    }
    @PutMapping("/{id}")
    CitizenDTO updateCitizen(@PathVariable long id, @RequestBody CitizenDTO citizen) {
        citizen.setId(id);
        return citizenService.updateCitizen(citizen);
    }
    @GetMapping
    List<CitizenDTO> getCitizens() {
        return citizenService.getAllCitizens();
    }
    @DeleteMapping("/{id}")
    void deleteCitizen(@PathVariable long id) {
        citizenService.deleteCitizen(id);
    }

}
