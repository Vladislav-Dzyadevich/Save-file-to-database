package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileToSave;

import java.util.List;

public interface FileService {

    void addFile(FileDto file);
    void deleteFile(Long id);
    List<FileToSave> listFiles();
}
