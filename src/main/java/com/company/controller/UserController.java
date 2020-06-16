package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.FileService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    @PostMapping("/registration")
    public String saveUser(@RequestParam("name") String name, @RequestParam("surName") String surName,
                           @RequestParam("login") String login,
                           @RequestParam("password") String password, Model model) {
        UserDto user = UserDto.builder()
                .name(name)
                .surName(surName)
                .login(login)
                .password(password)
                .build();
        if (userService.isLoginPresentInDb(login)) {
            model.addAttribute("error", "this login is already in use");
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
        public String userPage( Model model ){
        model.addAttribute("files", fileService.listFiles());
            return "userPage";
    }

}
