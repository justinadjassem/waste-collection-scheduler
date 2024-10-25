package com.wcs.waste_collection_scheduler.district;

import com.wcs.waste_collection_scheduler.home.Home;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DistrictDTO {
    private Long id;
    private String name;
    List<Home> homes;
}
