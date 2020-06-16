package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.Role;
import com.company.entity.CustomUser;

import java.util.List;

public interface UserService {
    void saveUserInDb(UserDto userDto);
    List<CustomUser> listUsers();
    UserDto findUserById(Long id);
    void deleteUser(Long id);
    void editUser(Long id, String newUserName, String newUserSurName, String newUserLogin, String newUserPassword);
    boolean checkUser(String login, String password);
    boolean isLoginPresentInDb(String login);
    Role checkRole(String login, String password);
    UserDto  findUserByLogin(String login);
}
