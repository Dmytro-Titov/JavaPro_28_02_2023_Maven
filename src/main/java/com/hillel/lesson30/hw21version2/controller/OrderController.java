package com.hillel.lesson30.hw21version2.controller;

import com.hillel.lesson30.hw21version2.dto.OrderDto;
import com.hillel.lesson30.hw21version2.dto.ProductDto;
import com.hillel.lesson30.hw21version2.service.OrderService;
import com.hillel.lesson30.hw21version2.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public OrderDto add(@RequestBody OrderDto orderDto) {
        return orderService.add(orderDto);
    }

    @PostMapping("/{orderId}/products")
    public ProductDto addToOrder(@PathVariable int orderId, @RequestBody ProductDto productDto) {
        return productService.addToOrder(orderId, productDto);
    }
}
