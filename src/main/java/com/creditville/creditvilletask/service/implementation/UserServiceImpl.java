package com.creditville.creditvilletask.service.implementation;

import com.creditville.creditvilletask.DTO.requestDTO.registerDTO;
import com.creditville.creditvilletask.entity.User;
import org.springframework.http.HttpStatus;
import com.creditville.creditvilletask.exception.ResourceNotFoundException;
import com.creditville.creditvilletask.exception.BadRequestException;
import com.creditville.creditvilletask.repository.UserRepository;
import com.creditville.creditvilletask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void activateUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        optionalUser.ifPresent(user -> {
            user.setActive(true);
            userRepository.save(user);
        });
    }

    @Override
    public boolean isUserActive(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

         return user.getActive();
    }

    @Override
    public String registerUser(registerDTO request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "User already exists!.");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }


        userRepository.save(user);

        return "User registered successfully!.";
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


}
