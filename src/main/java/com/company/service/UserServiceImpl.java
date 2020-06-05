package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUserInDb(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurName(userDto.getSurName());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Transactional
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
