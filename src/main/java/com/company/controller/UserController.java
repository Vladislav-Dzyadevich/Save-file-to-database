package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.FileStatus;
import com.company.service.FileService;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @PostMapping("/registration")
    public String saveUser(@RequestParam("name") String name, @RequestParam("surName") String surName,
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
    public String userPage(Model model) {
        model.addAttribute("files", fileService.getFileByStatus(FileStatus.PUBLIC));
        return "userPage";
    }

    @PostMapping("/send-mail/reset-password")
    public String resetPassword(@RequestParam("email") String email, Model model) {
        UserDto userDto = userService.findUserByEmail(email);
        if (userDto == null) {
            model.addAttribute("emailFail", "user with such email not found");
            return "enterEmailForRecoverPassword";
        }
        userService.sendResetMessage(userDto);
        return "ok";
    }

    @GetMapping("/send-mail/reset-password")
    public String resetPassword() {
        return "enterEmailForRecoverPassword";
    }
}
