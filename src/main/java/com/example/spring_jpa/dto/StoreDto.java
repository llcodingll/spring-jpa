package com.example.spring_jpa.dto;

import com.example.spring_jpa.store.domain.Store;

public record StoreDto(
        Long id,
        String name,
        String address
) {
    public static StoreDto from(Store store){
        return new StoreDto(
                store.getId()
                , store.getName()
                , store.getAddress()
        );
    }
}