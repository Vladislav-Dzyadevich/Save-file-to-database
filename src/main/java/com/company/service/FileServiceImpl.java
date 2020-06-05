package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileToSave;
import com.company.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public void addFile(FileDto file) {
        FileToSave fileToSave = new FileToSave();
        fileToSave.setFileName(file.getOriginFileName());
        fileToSave.setContent(file.getContent());
        fileToSave.setSize(file.getSize() / 1024);
        fileRepository.save(fileToSave);
    }
    @Transactional
    public void deleteFile(Long id){
        fileRepository.deleteById(id);
    }

    @Transactional
    public List<FileToSave> listFiles() {
        return fileRepository.findAll();
    }

    @Transactional
    public FileDto findFileById(Long id) {
        FileToSave file = fileRepository.findById(id).get();
        FileDto dto = new FileDto(file.getFileName(), file.getContent(), file.getSize());
        return dto;
    }

    @Override
    public void editFile(Long id, String newFileName) {
        FileToSave file = fileRepository.findById(id).get();
        file.setFileName(newFileName);
        fileRepository.save(file);

    }

    @Transactional
    public int fileCount() {
       int count = (int) fileRepository.count();
       return count;
    }

}
