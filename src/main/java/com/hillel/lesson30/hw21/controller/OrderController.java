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

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public Order removeOrder(@PathVariable int id) {
        return orderService.removeOrder(id);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @GetMapping("/{orderId}/products")
    public List<Product> getAllByOrderId(@PathVariable int orderId) {
        return orderService.getAllByOrderId(orderId);
    }

    @PostMapping("/{orderID}/products")
    public Product addProduct(@PathVariable int orderID, @RequestBody Product product) {
        return orderService.addProduct(orderID, product);
    }

    @DeleteMapping("/{orderId}/products/{productId}")
    public Product removeProduct(@PathVariable int orderId, @PathVariable int productId) {
        return orderService.removeProduct(orderId, productId);
    }

    @PutMapping("/{orderId}/products")
    public Product updateProduct(@PathVariable int orderId, @RequestBody Product product) {
        return orderService.updateProduct(orderId, product);
    }
}
