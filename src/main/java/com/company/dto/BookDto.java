package com.company.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BookDto {
    private String name;
    private String author;
    private String genre;
}
