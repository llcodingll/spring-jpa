package com.example.spring_jpa.user.controller;

import com.example.spring_jpa.user.request.UserRequest;
import com.example.spring_jpa.user.response.UserResponse;
import com.example.spring_jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/users")
    public UserResponse save(
            @RequestBody UserRequest request
    ){
        return userService.createUser(request);
    }

    @GetMapping("/api/v1/users")
    public List<UserResponse> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping
    public void test() {
        return;
    }
}