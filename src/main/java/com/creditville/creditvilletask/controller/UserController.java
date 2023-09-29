package com.creditville.creditvilletask.controller;


import com.creditville.creditvilletask.DTO.requestDTO.registerDTO;
import com.creditville.creditvilletask.entity.User;
import com.creditville.creditvilletask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Object> register(@RequestBody registerDTO request){
        String response = userService.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers(){
        List<User> response = userService.findAllUsers();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @PostMapping("/activate/{userId}")
    public ResponseEntity<String> activateUser(@PathVariable Long userId) {
        userService.activateUser(userId);
        return ResponseEntity.ok("User activated successfully.");
    }

    @GetMapping("/check-status/{userId}")
    public ResponseEntity<String> checkUserStatus(@PathVariable Long userId) {
        boolean isActive = userService.isUserActive(userId);
        if (isActive) {
            return ResponseEntity.ok("User is active.");
        } else {
            return ResponseEntity.ok("User is inactive.");
        }
    }
}
