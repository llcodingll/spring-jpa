package com.example.spring_jpa.store.service;

import com.example.spring_jpa.store.request.StoreRequest;
import com.example.spring_jpa.store.response.StoreResponse;

import java.util.List;

public interface StoreService {
    StoreResponse saveStore(StoreRequest storeRequest);
    List<StoreResponse> getAllStore();
}
