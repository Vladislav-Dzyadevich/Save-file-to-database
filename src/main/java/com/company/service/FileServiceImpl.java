package com.company.service;

import com.company.dto.FileDto;
import com.company.entity.FileToSave;
import com.company.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Transactional
    public void addFile(FileDto file) {
        FileToSave fileToSave = new FileToSave();
        fileToSave.setFileName(file.getOriginFileName());
        fileToSave.setContent(file.getContent());
        fileToSave.setSize(file.getSize());
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

}
