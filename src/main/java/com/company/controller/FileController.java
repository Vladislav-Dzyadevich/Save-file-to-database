package com.company.controller;

import com.company.dto.FileDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import com.company.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    static final int ITEMS_PER_PAGE = 5;
    @Autowired
    private FileService fileService;

    @GetMapping("/admin/menu")
    public String indexPage(Model model, @RequestParam(value = "name", required = false) String name,
                            @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        PageRequest pageParameters = PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id");
        Page<FileToSave> files;
        if (name != null) {
            files = fileService.findByFileName(pageParameters, name);
            model.addAttribute("name", name);
        } else {
            files = fileService.listFiles(pageParameters);
        }
        model.addAttribute("files", files.getContent());
        model.addAttribute("allPages", getPageCount(files.getTotalElements()));
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
    public String saveFile(@RequestParam("file") MultipartFile file,
                           @RequestParam(value = "status", defaultValue = "PUBLIC") FileStatus status,
                           @AuthenticationPrincipal Authentication auth, Model model) throws IOException {

        FileDto dto = FileDto.builder()
                .content(file.getBytes())
                .originFileName(file.getOriginalFilename())
                .size(file.getSize())
                .fileStatus(status)
                .build();
        fileService.addFile(dto, auth.getName());
        return "ok";
    }

    @PostMapping("/fileForUser")
    public String saveFileForUSer(@RequestParam("file") MultipartFile file,
                                  @RequestParam(value = "status", defaultValue = "PUBLIC") FileStatus status,
                                  @AuthenticationPrincipal Authentication auth) throws IOException {
        FileDto dto = FileDto.builder()
                .originFileName(file.getOriginalFilename())
                .content(file.getBytes())
                .size(file.getSize())
                .fileStatus(status)
                .build();
        fileService.addFile(dto, auth.getName());
        return "okForUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable("id") Long fileId) {
        fileService.deleteFile(fileId);
        return "redirect:/admin/menu";
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

    @GetMapping("/admin/edit/{id}")
    public String editFilePage(@PathVariable("id") Long fileId, Model model) {
        model.addAttribute("fileName", fileService.findFileById(fileId).getOriginFileName());
        model.addAttribute("fileId", fileId);
        fileService.findFileById(fileId);
        return "edit";
    }

    @PostMapping("/admin/edit/{id}")
    public String editFile(@PathVariable("id") Long fileId, @RequestParam("newFileName") String newFileName) {
        fileService.editFile(fileId, newFileName);
        return "redirect:/admin/menu";
    }

    @GetMapping("/storage/private-files")
    public String storagePrivateFiles(@AuthenticationPrincipal Authentication auth, Model model,
                                      @RequestParam(value = "name", required = false) String name,
                                      @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        PageRequest pageParameters = PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id");
        Page<FileToSave> files;
        if (name != null) {
            files = fileService.getFileByStatus(pageParameters, name, FileStatus.PRIVATE);
            model.addAttribute("name", name);
        } else {
            files = fileService.findAllByUserLoginAndFileStatusIs(pageParameters, auth.getName(), FileStatus.PRIVATE);
        }
        model.addAttribute("files", files.getContent());
        model.addAttribute("allPages", getPageCount(files.getTotalElements()));
        return "showPrivatefiles";

    }

    private long getPageCount(long totalCount) {
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}
