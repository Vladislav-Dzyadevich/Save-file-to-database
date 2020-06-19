package com.company.controller;

import com.company.dto.UserDto;
import com.company.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String indexPage() {
        return "redirect:/welcome";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/authorization")
    public String authorizationPage() {
        return "authorization";
    }


    @GetMapping("/unauthorized")
    public String authorization() {
        return "unauthorized";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "welcome";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("newPassword") String newPassword, @RequestParam("email") String email) {
        userService.resetPassword(newPassword, email);
        return "ok";
    }

    @GetMapping("/reset-password/{email}")
    public String resetPassword(@PathVariable("email") String email) {
        return "EnterYourNewPassword";
    }


}
