package com.company.controller;

import com.company.dto.UserDto;
import com.company.entity.CustomUser;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    static final int ITEMS_PER_PAGE = 5;
    @Autowired
    private UserService userService;

    @GetMapping("/allUsers")
    public String allUsers(Model model, @RequestParam(value = "name", required = false) String name,
                           @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        PageRequest pageParameters = PageRequest.of(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id");
        Page<CustomUser> users;

        if (name != null) {
            users = userService.findByNameAndSurName(pageParameters, name);
            model.addAttribute("name", name);
        } else {
            users = userService.listUsers(pageParameters);
        }
        model.addAttribute("users", users.getContent());
        model.addAttribute("allPages", getPageCount(users.getTotalElements()));
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
                                @RequestParam("newUserEmail") String newUserEmail, Model model) {
        if (!userService.isEmailValid(newUserEmail)) {
            model.addAttribute("IncorrectEmail", "Sorry, this email is incorrect");
            return "editUser";
        }
        userService.editUser(userId, newUserName, newUserSurName, newUserLogin, newUserEmail);
        return "redirect:/admin/allUsers";
    }

    @GetMapping("/table-given")
    public String tableGiven() {
        return "tableGiven";
    }

    private long getPageCount(long totalCount) {
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
}
