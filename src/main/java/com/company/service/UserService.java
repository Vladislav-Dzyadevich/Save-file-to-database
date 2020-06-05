package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;

import java.util.List;

public interface UserService {
    void saveUserInDb(UserDto userDto);
    List<User> listUsers();
}
