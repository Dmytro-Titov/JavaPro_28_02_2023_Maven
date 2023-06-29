package com.hillel.lesson30.hw21version2.repository;

import com.hillel.lesson30.hw21version2.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByOrderId(int orderId);
}
