package com.company.dto;

import com.company.entity.CustomUser;
import com.company.entity.FileStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FileDto {

    private String originFileName;
    private byte[] content;
    private long size;
    private FileStatus fileStatus;

}
