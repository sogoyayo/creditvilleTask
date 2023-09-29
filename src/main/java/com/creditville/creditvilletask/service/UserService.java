package com.creditville.creditvilletask.service;

import com.creditville.creditvilletask.DTO.requestDTO.registerDTO;
import com.creditville.creditvilletask.entity.User;

import java.util.List;

public interface UserService {
    void activateUser(Long userId);

    boolean isUserActive(Long id);

    String registerUser(registerDTO register);

    List<User> findAllUsers();
}
