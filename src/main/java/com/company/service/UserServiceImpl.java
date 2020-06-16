package com.company.service;

import com.company.entity.Role;
import com.company.dto.UserDto;
import com.company.entity.CustomUser;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    public void saveUserInDb(UserDto userDto) {
        CustomUser user = new CustomUser();
        user.setName(userDto.getName());
        user.setRole(Role.USER);
        user.setSurName(userDto.getSurName());
        user.setLogin(userDto.getLogin());
        user.setPassword(encoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDto findUserById(Long id) {
        CustomUser user = userRepository.findById(id).get();
        UserDto dto =  UserDto.builder()
                .name(user.getName())
                .surName(user.getSurName())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        return dto;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Role checkRole(String login, String password) {
        List<CustomUser> all = userRepository.findAll();
        for (CustomUser user : all) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user.getRole();
            }
        }
        return null;
    }

    @Override
    public UserDto findUserByLogin(String login) {
        CustomUser customUser = userRepository.findByLogin(login);
        UserDto dto =  UserDto.builder()
                .name(customUser.getName())
                .surName(customUser.getSurName())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .role(customUser.getRole())
                .build();

        return dto;
    }

    @Override
    public boolean isLoginPresentInDb(String login) {
        List<CustomUser> all = userRepository.findAll();
        for (CustomUser user : all) {
            if (user.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkUser(String login, String password) {
        List<CustomUser> all = userRepository.findAll();
        for (CustomUser user : all) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void editUser(Long id, String newUserName, String newUserSurName, String newUserLogin, String newUserPassword) {
        CustomUser user = userRepository.findById(id).get();
        user.setName(newUserName);
        user.setSurName(newUserSurName);
        user.setLogin(newUserLogin);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        userRepository.save(user);
    }

    @Transactional
    public List<CustomUser> listUsers() {
        return userRepository.findAll();
    }
}
