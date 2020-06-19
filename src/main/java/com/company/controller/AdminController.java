package com.company.controller;

import com.company.dto.UserDto;
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
    public String allUsers(Model model, @RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            model.addAttribute("users", userService.findByNameAndSurName(name));
        } else {
            model.addAttribute("users", userService.listUsers());
        }
        return "allUsers";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteFile(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/editUserLogin/{id}")
    public String editUserLog(@PathVariable("id") Long userId, Model model) {
        UserDto userById = userService.findUserById(userId);
        model.addAttribute("userName", userById.getName());
        model.addAttribute("userSurName", userById.getSurName());
        model.addAttribute("userLogin", userById.getLogin());
        model.addAttribute("userPassword", userById.getPassword());
        model.addAttribute("userEmail", userById.getEmail());
        model.addAttribute("userId", userId);
        return "editUser";
    }

    @PostMapping("/editUserLogin/{id}")
    public String editUserLogin(@PathVariable("id") Long userId, @RequestParam("newUserName") String newUserName,
                                @RequestParam("newUserSurName") String newUserSurName,
                                @RequestParam("newUserLogin") String newUserLogin,
                                @RequestParam("newUserPassword") String newUserPassword,
                                @RequestParam("newUserEmail") String newUserEmail, Model model) {
        if (!userService.isEmailValid(newUserEmail)) {
            model.addAttribute("IncorrectEmail", "Sorry, this email is incorrect");
            return "editUser";
        }
        userService.editUser(userId, newUserName, newUserSurName, newUserLogin, newUserPassword, newUserEmail);
        return "redirect:/admin/allUsers";
    }
}
