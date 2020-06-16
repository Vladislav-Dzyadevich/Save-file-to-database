package com.company.controller;

import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "allUsers";
    }

    @GetMapping("/deleteUSer/{id}")
    public String deleteFile(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/allUsers";
    }

    @GetMapping("/editUserLogin/{id}")
    public String editUserLog(@PathVariable("id") Long userId, Model model) {
        model.addAttribute("userLogin", userService.findUserById(userId).getLogin());
        model.addAttribute("userId", userId);
        userService.findUserById(userId);
        return "editUser";
    }

    @PostMapping("/editUserLogin/{id}")
    public String editUserLogin(@PathVariable("id") Long userId, @RequestParam("newUserName") String newUserName,
                                @RequestParam("newUserSurName") String newUserSurName,
                                @RequestParam("newUserLogin") String newUserLogin,
                                @RequestParam("newUserPassword") String newUserPassword) {
        userService.editUser(userId, newUserName, newUserSurName, newUserLogin, newUserPassword);
        return "redirect:/allUsers";
    }
}
