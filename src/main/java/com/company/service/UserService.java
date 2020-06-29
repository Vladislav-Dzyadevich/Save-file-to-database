package com.company.service;

import com.company.dto.FileDto;
import com.company.dto.UserDto;
import com.company.entity.CustomUser;
import com.company.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void saveUserInDb(UserDto userDto);

    Page<CustomUser> listUsers(Pageable pageable);

    UserDto findUserById(Long id);

    void deleteUser(Long id);

    void editUser(Long id, String newUserName, String newUserSurName, String newUserLogin, String newUserEmail);

    boolean checkUser(String login, String password);

    boolean isLoginPresentInDb(String login);

    Role checkRole(String login, String password);

    UserDto findUserByLogin(String login);

    UserDto findUserByEmail(String email);

    Page<CustomUser> findByNameAndSurName(Pageable pageable, String name);

    boolean isEmailPresentInDb(String email);

    boolean isEmailValid(String email);

    void sendResetMessage(UserDto email);

    void resetPassword(String newPassword, String email);

    List<FileDto> showUploadFiles(UserDto userDto);

    long count();
}
