package com.wcs.waste_collection_scheduler.district;

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
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictDtoMapperImpl districtDtoMapper;

    @Override
    public DistrictDTO createDistrict(DistrictDTO districtDTO) {
        District district = districtDtoMapper.toEntity(districtDTO);
        try{
            District CreatedDistrict = districtRepository.save(district);
            return districtDtoMapper.toDto(CreatedDistrict);
        }catch(Exception e){
            log.error("Failed to create district : {}", e.getMessage());
            throw new RuntimeException("Failed to create district");
        }
    }

    @Override
    public DistrictDTO getDistrict(Long id) throws DistrictNotFoundException {
        log.info("Retrieving district with id: {}" ,id);
        District district = districtRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new DistrictNotFoundException("Home not found"));
        return districtDtoMapper.toDto(district);
    }

    @Override
    public DistrictDTO updateDistrict(DistrictDTO district) throws DistrictNotFoundException {
        if (districtRepository.existsByIdAndDeletedFalse(district.getId())) {
            District updatedDistrict = districtDtoMapper.toEntity(district);
            log.info("Updating district with id: {}" ,district.getId());
            return districtDtoMapper.toDto(districtRepository.save(updatedDistrict));
        }
        throw new DistrictNotFoundException("District with id "+ district.getId() + " not found");
    }

    @Override
    public void districtLogicalDeletion(Long id) throws DistrictNotFoundException {
        log.info("Deleting district with id: {}" ,id);
        District district = districtRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(()-> new DistrictNotFoundException(" District with id "+ id +" not found"));
        district.delete();
        districtRepository.save(district);
    }

    @Override
    public List<DistrictDTO> getAllDistrict() {
        log.info("Retrieving all districts");
        List<District> districts = districtRepository.findAll();
        return districts.stream()
                .filter(district -> !district.isDeleted())
                .map(district -> districtDtoMapper.toDto(district))
                .collect(Collectors.toList());
    }
}
