package com.wcs.waste_collection_scheduler.citizen;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/Citizen")
@Tag(name = "Citizen")
public class CitizenRestController {
    private final CitizenService citizenService;

    @PostMapping("/create")
    CitizenDTO createCitizen(@RequestBody CitizenDTO citizen) {
        return citizenService.createCitizen(citizen);
    }
    @GetMapping("/{id}")
    CitizenDTO getCitizen(@PathVariable long id) throws CitizenNotFoundException {
        return citizenService.getCitizen(id);
    }
    @PutMapping("/update/{id}")
    CitizenDTO updateCitizen(@PathVariable long id, @RequestBody CitizenDTO citizen) {
        citizen.setId(id);
        return citizenService.updateCitizen(citizen);
    }
    @GetMapping("/citizens")
    List<CitizenDTO> getCitizens() {
        return citizenService.getAllCitizens();
    }
    @DeleteMapping("/delete/{id}")
    void deleteCitizen(@PathVariable long id) {
        citizenService.deleteCitizen(id);
    }

}
