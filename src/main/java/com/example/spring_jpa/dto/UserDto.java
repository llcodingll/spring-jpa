package com.example.spring_jpa.dto;

import com.example.spring_jpa.user.domain.User;

public record UserDto(
        Long id,
        String email,
        String username
) {
    public static UserDto from(User user){
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );
    }
}