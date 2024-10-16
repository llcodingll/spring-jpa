package com.example.spring_jpa.store.response;

import com.example.spring_jpa.dto.UserDto;
import com.example.spring_jpa.store.domain.Store;

public record StoreResponse(
        Long id,
        String name,
        String address,
        UserDto user
) {
    public static StoreResponse from(Store store){
        return new StoreResponse(
                store.getId()
                , store.getName()
                , store.getAddress()
                , UserDto.from(store.getUser())
        );
    }
}
