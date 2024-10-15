package com.example.spring_jpa.user.response;

import com.example.spring_jpa.user.domain.User;

public record UserResponse(
        Long id,
        String email,
        String username
) {
    public static UserResponse from(User user) { //생성되기 전에 쓰는 건 static 사용
        return new UserResponse(user.getId(), user.getEmail(), user.getUsername());
    }
}
