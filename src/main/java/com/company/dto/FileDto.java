package com.company.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
public class FileDto {

    private String originFileName;
    private byte[] content;
    private long size;

}
