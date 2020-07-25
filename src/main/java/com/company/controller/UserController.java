package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.FileStatus;
import com.company.entity.FileToSave;
import com.company.service.FileService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {
    static final int ITEMS_PER_PAGE = 5;
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @PostMapping("/registration")
    public String saveUser(@RequestParam("name") String name,
                           @RequestParam("surName") String surName,
                           @RequestParam("login") String login,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email, Model model) {
        if (name.isBlank() || surName.isBlank()
                || login.isBlank()
                || password.isBlank()
                || email.isBlank()) {
            model.addAttribute("emptyFields", "Fields must not be empty");
            return "registration";
        }
        if (!userService.isEmailValid(email)) {
            model.addAttribute("IncorrectEmail", " Sorry, this email is incorrect");
            return "registration";
        }

        UserDto user = UserDto.builder()
                .name(name)
                .surName(surName)
                .login(login)
                .password(password)
                .email(email)
                .build();

        if (userService.isLoginPresentInDb(login)) {
            model.addAttribute("error", "this login is already in use");
            return "registration";
        }
        if (userService.isEmailPresentInDb(email)) {
            model.addAttribute("error", "this email is already in use");
            return "registration";
        }


        userService.saveUserInDb(user);
        return "okForRegistration";
    }

    @GetMapping("/registration")
    public String savePage() {
        return "registration";
    }

    @GetMapping("/userPage")
    public String userPage(Model model, @RequestParam(value = "name", required = false) String name,
                           @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        PageRequest pageParameters = PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id");
        Page<FileToSave> files;
        if (name != null) {
            files = fileService.getFileByStatus(pageParameters, name, FileStatus.PUBLIC);
            model.addAttribute("name", name);
        } else {
            files = fileService.listFilesWithPublicStatus(FileStatus.PUBLIC, pageParameters);
        }
        model.addAttribute("files", files.getContent());
        model.addAttribute("allPages", getPageCount(files.getTotalElements()));
        return "userPage";
    }

    @PostMapping("/send-mail/reset-password")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        log.info("resetPassword - Before find user by email");
        UserDto userDto = userService.findUserByEmail(email);
        log.info("resetPassword - Before if");
        if (userDto == null) {
            model.addAttribute("emailFail", "user with such email not found");
            log.info("resetPassword - email fail");
            return "enterEmailForRecoverPassword";
        }
        log.info("resetPassword - Before sendResetMessage");
        userService.sendResetMessage(userDto);
        log.info("resetPassword - after sendResetMessage");
        return "okForEmail";
    }

    @GetMapping("/send-mail/reset-password")
    public String resetPassword() {
        return "enterEmailForRecoverPassword";
    }

    private long getPageCount(long totalCount) {
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
