package com.example.spring_jpa.store.request;

import com.example.spring_jpa.store.domain.Store;
import com.example.spring_jpa.user.domain.User;

import java.util.ArrayList;

public record StoreRequest(
        String name,
        String address,
        Long userId
) {
    public Store toEntity(){
        User user = User.builder().id(userId).build();
        return new Store(null, name, address, user, new ArrayList<>());
    }
}
