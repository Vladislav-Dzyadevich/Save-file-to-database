package com.company.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class TravelDto {
    private String city;
    private String country;
    private String continent;
    private Long yearOfVisit;
}
