package com.example.spring_jpa.store.service;

import com.example.spring_jpa.store.domain.Store;
import com.example.spring_jpa.store.repository.StoreRepository;
import com.example.spring_jpa.store.request.StoreRequest;
import com.example.spring_jpa.store.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    @Override
    public StoreResponse saveStore(StoreRequest storeRequest) {
        Store entity = storeRequest.toEntity();
        storeRepository.save(entity);
        return StoreResponse.from(entity);
    }

    @Override
    public List<StoreResponse> getAllStore() {
        return storeRepository.findJoinAll()
                .stream()
                .map(StoreResponse::from)
                .toList();
    }
}
