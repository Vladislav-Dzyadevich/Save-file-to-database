package com.company.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MusicDto {

    private String name;

    private String genre;

    private String author;

}
