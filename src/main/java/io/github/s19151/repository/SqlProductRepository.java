package io.github.s19151.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.s19151.model.Product;

@Repository
public interface SqlProductRepository extends ProductRepository, JpaRepository<Product, Integer>{

}
