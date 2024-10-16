package com.example.spring_jpa.order.repository;

import com.example.spring_jpa.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
