package com.example.spring_jpa.store.repository;

import com.example.spring_jpa.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
