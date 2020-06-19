package com.company.dto;

import com.company.entity.FileToSave;
import com.company.entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UserDto {
    private String name;
    private String surName;
    private String login;
    private String password;
    private Role role;
    private String email;
    private FileToSave fileToSave;

}

