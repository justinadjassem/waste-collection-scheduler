package com.wcs.waste_collection_scheduler.citizen;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitizenAuthRequest {
    private String email;
    private String password;
}
