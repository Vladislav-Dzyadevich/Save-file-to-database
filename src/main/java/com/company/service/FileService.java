package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;

import java.util.List;

public interface FileService {

    void addFile(FileDto file, String ownerLogin);

    void deleteFile(Long id);

    List<FileToSave> listFiles();

    FileDto findFileById(Long id);

    int fileCount();

    void editFile(Long id, String newFileName);

    List<FileToSave> findByFileName(String name);

    List<FileToSave> getFileByStatus(FileStatus fileStatus);

    List<FileToSave> findAllByUserLoginAndFileStatusIs(String userLogin, FileStatus fileStatus);
}
