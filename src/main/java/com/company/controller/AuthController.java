package com.company.controller;

import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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


}
