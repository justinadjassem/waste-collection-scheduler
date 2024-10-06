package com.wcs.waste_collection_scheduler.home;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String longitude;
    private String latitude;
    private Long numberOfCitizen;
}
