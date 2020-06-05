package com.company.controller;

import com.company.dto.FileDto;
import com.company.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("files", fileService.listFiles());
        return "index";
    }

    @GetMapping("/upload")
    public String uploadFilePage() {
        return "upload";
    }

    @PostMapping("/file")
    public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileDto dto = new FileDto(file.getOriginalFilename(), file.getBytes(), file.getSize());
        fileService.addFile(dto);
        return "ok";
    }

    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable("id") Long fileId) {
        fileService.deleteFile(fileId);
        return "index";
    }
}
