package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.UserService;
import org.dom4j.rule.Mode;
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

    @PostMapping("/registration")
    public String saveUser(@RequestParam("name") String name, @RequestParam("surName") String surName,
                           @RequestParam("login") String login,
                           @RequestParam("password") String password) {

        UserDto user = new UserDto(name, surName, login, password);
        userService.saveUserInDb(user);
        return "ok";
    }

    @GetMapping("/registration")
    public String savePage() {
        return "registration";
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model){
        model.addAttribute("users" , userService.listUsers());
        return "allUsers";
    }
}
