package io.github.s19151.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.s19151.model.Order;

@Repository
public interface SqlOrderRepository extends OrderRepository, JpaRepository<Order, Integer>{

}
