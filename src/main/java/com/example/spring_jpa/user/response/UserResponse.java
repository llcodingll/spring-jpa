package com.example.spring_jpa.user.response;

import com.example.spring_jpa.user.domain.User;

public record UserResponse(
        String email,
        String username
) {
    public User fromEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .build();
    }
}
