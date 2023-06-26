package com.hillel.lesson30.hw21.controller;

import com.hillel.lesson30.hw21.model.Order;
import com.hillel.lesson30.hw21.model.Product;
import com.hillel.lesson30.hw21.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/id/{id}")
    public Order getById(@PathVariable int id) {
        return orderService.getById(id);
    }
    @GetMapping("/username/{username}")
    public Order getByUsername(@PathVariable String username) {
        return orderService.getByUsername(username);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("/id/{orderId}/products")
    public List<Product> getAllProductsByOrderId(@PathVariable int orderId) {
        return orderService.getAllProductsByOrderId(orderId);
    }

    @GetMapping("/username/{username}/products")
    public List<Product> getAllProductsByUsername(@PathVariable String username) {
        return orderService.getAllProductsByUsername(username);
    }

    @PostMapping("/{orderID}/products")
    public Product addProductToOrder(@PathVariable int orderID, @RequestBody Product product) {
        return orderService.addProductToOrder(orderID, product);
    }
}
