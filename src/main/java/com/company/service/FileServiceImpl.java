package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import com.company.repository.FileRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FileServiceImpl implements FileService {
    static final int ITEMS_PER_PAGE = 5;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addFile(FileDto file, String ownerLogin) {
        FileToSave fileToSave = new FileToSave();
        fileToSave.setFileName(file.getOriginFileName());
        fileToSave.setContent(file.getContent());
        fileToSave.setSize(file.getSize() / 1024);
        fileToSave.setFileStatus(file.getFileStatus());
        fileToSave.setUser(userRepository.findByLogin(ownerLogin));
        fileRepository.save(fileToSave);
    }

    @Transactional
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }


    @Transactional
    public Page<FileToSave> listFiles(Pageable pageable) {
        return fileRepository.findAll(pageable);
    }

    @Override
    public Page<FileToSave> listFilesWithPublicStatus(FileStatus status, Pageable pageable) {
        return fileRepository.findAllByFileStatusIs(status, pageable);
    }

    @Transactional
    public FileDto findFileById(Long id) {
        FileToSave file = fileRepository.findById(id).get();
        FileDto dto = FileDto.builder()
                .originFileName(file.getFileName())
                .content(file.getContent())
                .size(file.getSize())
                .build();
        return dto;
    }


    @Override
    public Page<FileToSave> findAllByUserLoginAndFileStatusIs(Pageable pageable, String userLogin, FileStatus fileStatus) {
        return fileRepository.findAllByUser_LoginAndFileStatusIs(pageable, userLogin, fileStatus);
    }

    @Override
    public Page<FileToSave> getFileByStatus(Pageable pageable, String name, FileStatus fileStatus) {
        return fileRepository.findAllByFileStatusOrderByIdDesc(pageable, name, fileStatus);
    }

    @Override
    public Page<FileToSave> findByFileName(Pageable pageable, String name) {
        return fileRepository.findByFileName(pageable, name);
    }

    @Override
    public void editFile(Long id, String newFileName) {
        FileToSave file = fileRepository.findById(id).get();
        file.setFileName(newFileName);
        fileRepository.save(file);
    }

    @Transactional
    public int fileCount() {
        return (int) fileRepository.count();
    }

}
