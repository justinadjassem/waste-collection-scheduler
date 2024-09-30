package com.wcs.waste_collection_scheduler.citizen;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitizenDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
