package com.wcs.waste_collection_scheduler.district;

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
@RequestMapping("/District")
@Tag(name = "District")
public class DistrictRestController {
    private final DistrictService districtService;

    @PostMapping
    DistrictDTO addDistrict(@Valid @RequestBody DistrictDTO district) {
        return districtService.createDistrict(district);
    }
    @GetMapping
    List<DistrictDTO> getDistricts() {
        return districtService.getAllDistrict();
    }
    @GetMapping("/{id}")
    ResponseEntity<DistrictDTO> getDistrict(@PathVariable Long id) throws DistrictNotFoundException {
        DistrictDTO districtDTO = districtService.getDistrict(id);
        return ResponseEntity.ok(districtDTO);
    }
    @PutMapping("/{id}")
    DistrictDTO updateDistrict(@PathVariable Long id,@Valid @RequestBody DistrictDTO district) throws DistrictNotFoundException {
        district.setId(id);
        return districtService.updateDistrict(district);
    }
    @DeleteMapping("/{id}")
    void deleteDistrict(@PathVariable Long id) throws DistrictNotFoundException {
        districtService.districtLogicalDeletion(id);
    }
}
