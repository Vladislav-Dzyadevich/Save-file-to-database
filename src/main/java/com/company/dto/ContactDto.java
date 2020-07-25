package com.company.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ContactDto {
    private String name;
    private String surName;
    private Long number;
}
