package com.company.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class NotesDto {
    private String name;
}
