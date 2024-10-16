package com.example.spring_jpa.user.response;


import com.example.spring_jpa.dto.StoreDto;
import com.example.spring_jpa.user.domain.User;

import java.util.List;

public record UserResponse(
        Long id,
        String email,
        String username,
        List<StoreDto> stores
) {
    public static UserResponse from(User user){
        var list = user.getStores()
                .stream()
                .map(StoreDto::from)
                .toList();
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                list
        );
    }
}