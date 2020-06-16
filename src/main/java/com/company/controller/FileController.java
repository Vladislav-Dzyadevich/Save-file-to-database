package com.company.controller;

import com.company.dto.FileDto;
import com.company.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/menu")
    public String indexPage(Model model) {
        model.addAttribute("files", fileService.listFiles());
        return "index";
    }

    @GetMapping("/upload")
    public String uploadFilePage() {
        return "upload";
    }

    @GetMapping("/uploadForUser")
    public String uploadForUser() {
        return "uploadForUser";
    }

    @PostMapping("/file")
    public String saveFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileDto dto = FileDto.builder()
                .content(file.getBytes())
                .originFileName(file.getOriginalFilename())
                .size(file.getSize())
                .build();

        fileService.addFile(dto);
        return "ok";
    }

    @PostMapping("/fileForUser")
    public String saveFileForUSer(@RequestParam("file") MultipartFile file) throws IOException {
        FileDto dto = FileDto.builder()
                .originFileName(file.getOriginalFilename())
                .content(file.getBytes())
                .size(file.getSize())
                .build();
        fileService.addFile(dto);
        return "okForUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable("id") Long fileId) {
        fileService.deleteFile(fileId);
        return "redirect:/allUsers";
    }

    @GetMapping("/download/{id}")
    public String downloadFile(@PathVariable("id") Long fileId, HttpServletResponse response) throws IOException {
        FileDto dto = fileService.findFileById(fileId);
        response.setContentType("application/msword");
        response.setContentLength(dto.getContent().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + dto.getOriginFileName() + "\"");
        FileCopyUtils.copy(dto.getContent(), response.getOutputStream());
        return "index";
    }

    @GetMapping("/show")
    public String showFilesInDatabase(Model model) {
        model.addAttribute("allFiles", fileService.fileCount());
        return "show";
    }

    @GetMapping("/edit/{id}")
    public String editFilePage(@PathVariable("id") Long fileId, Model model) {
        model.addAttribute("fileName", fileService.findFileById(fileId).getOriginFileName());
        model.addAttribute("fileId", fileId);
        fileService.findFileById(fileId);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editFile(@PathVariable("id") Long fileId, @RequestParam("newFileName") String newFileName) {
        fileService.editFile(fileId, newFileName);
        return "redirect:/menu";
    }

}
