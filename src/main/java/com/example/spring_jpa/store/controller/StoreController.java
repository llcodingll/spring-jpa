package com.example.spring_jpa.store.controller;

import com.example.spring_jpa.store.request.StoreRequest;
import com.example.spring_jpa.store.response.StoreResponse;
import com.example.spring_jpa.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/api/v1/stores")
    public List<StoreResponse> getAllStores(){
        return storeService.getAllStore();
    }

    @PostMapping("/api/v1/stores")
    public StoreResponse saveStore(
            @RequestBody StoreRequest request
    ){
        return storeService.saveStore(request);
    }
}
