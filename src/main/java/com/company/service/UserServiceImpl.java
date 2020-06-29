package com.company.service;

import com.company.dto.FileDto;
import com.company.dto.UserDto;
import com.company.entity.CustomUser;
import com.company.entity.Role;
import com.company.mail.MailingService;
import com.company.repository.UserRepository;
import com.company.util.LinkGeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private MailingService mailingService;

    @Transactional
    public void saveUserInDb(UserDto userDto) {
        CustomUser user = new CustomUser();
        user.setName(userDto.getName());
        user.setRole(Role.USER);
        user.setSurName(userDto.getSurName());
        user.setLogin(userDto.getLogin());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
    }

    @Override
    public UserDto findUserById(Long id) {
        CustomUser user = userRepository.findById(id).get();
        UserDto dto = UserDto.builder()
                .name(user.getName())
                .surName(user.getSurName())
                .login(user.getLogin())
                .email(user.getEmail())
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
    public boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public List<FileDto> showUploadFiles(UserDto userDto) {
        return null;
    }

    @Override
    public void resetPassword(String newPassword, String email) {
        CustomUser user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(encoder.encode(newPassword));
            userRepository.save(user);
        }
    }

    @Override
    public void sendResetMessage(UserDto user) {
        mailingService.setResetLink(LinkGeneratorUtils.generateResetLink(user.getEmail()));
        mailingService.sendUserResetPasswordMessage(user);
    }

    @Override
    public boolean isEmailPresentInDb(String email) {
        List<CustomUser> users = userRepository.findAll();
        for (CustomUser user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Page<CustomUser> findByNameAndSurName(Pageable pageable, String name) {
        return userRepository.findByNameAndSurName(pageable, name);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        CustomUser customUser = userRepository.findByEmail(email);
        if (customUser != null) {
            UserDto userDto = UserDto.builder()
                    .name(customUser.getName())
                    .surName(customUser.getSurName())
                    .login(customUser.getLogin())
                    .password(customUser.getPassword())
                    .role(customUser.getRole())
                    .email(customUser.getEmail())
                    .build();
            return userDto;
        }
        return null;

    }

    @Override
    public UserDto
    findUserByLogin(String login) {
        CustomUser customUser = userRepository.findByLogin(login);
        UserDto dto = UserDto.builder()
                .name(customUser.getName())
                .surName(customUser.getSurName())
                .login(customUser.getLogin())
                .password(customUser.getPassword())
                .role(customUser.getRole())
                .email(customUser.getEmail())
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
    public void editUser(Long id, String newUserName, String newUserSurName, String newUserLogin, String newUserEmail) {
        CustomUser user = userRepository.findById(id).get();
        user.setName(newUserName);
        user.setSurName(newUserSurName);
        user.setLogin(newUserLogin);
        user.setEmail(newUserEmail);
        userRepository.save(user);
    }

    @Transactional
    public Page<CustomUser> listUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
