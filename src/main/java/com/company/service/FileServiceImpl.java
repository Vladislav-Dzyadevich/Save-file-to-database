package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import com.company.repository.FileRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {

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
    public List<FileToSave> listFiles() {
        return fileRepository.findAll();
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
    public List<FileToSave> findAllByUserLoginAndFileStatusIs(String userLogin, FileStatus fileStatus) {
        return fileRepository.findAllByUser_LoginAndFileStatusIs(userLogin, fileStatus);
    }

    @Override
    public List<FileToSave> getFileByStatus(FileStatus fileStatus) {
        return fileRepository.findAllByFileStatus(fileStatus);
    }

    @Override
    public List<FileToSave> findByFileName(String name) {
        return fileRepository.findByFileName(name);
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
