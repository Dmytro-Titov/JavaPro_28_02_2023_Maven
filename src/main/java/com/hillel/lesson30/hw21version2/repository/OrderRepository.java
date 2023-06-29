package com.hillel.lesson30.hw21version2.repository;

import com.hillel.lesson30.hw21version2.entity.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    Order findById(int id);
    List<Order> findAll();
}
