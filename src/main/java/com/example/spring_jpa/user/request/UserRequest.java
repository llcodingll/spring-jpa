package com.example.spring_jpa.user.request;

import com.example.spring_jpa.user.domain.User;

public record UserRequest(
        String email,
        String password,
        String username
) {
    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .build();
    }
}
