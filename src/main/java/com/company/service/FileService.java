package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FileService {

    void addFile(FileDto file, String ownerLogin);

    void deleteFile(Long id);

    Page<FileToSave> listFiles(Pageable pageable);

    Page<FileToSave> listFilesWithPublicStatus(FileStatus status, Pageable pageable);

    FileDto findFileById(Long id);

    int fileCount();

    void editFile(Long id, String newFileName);

    Page<FileToSave> findByFileName(Pageable pageable, String name);

    Page<FileToSave> getFileByStatus(Pageable pageable, String name, FileStatus fileStatus);

    Page<FileToSave> findAllByUserLoginAndFileStatusIs(Pageable pageable, String userLogin, FileStatus fileStatus);


}
