package com.hillel.lesson30.hw21version2.service;

import com.hillel.lesson30.hw21version2.Converter;
import com.hillel.lesson30.hw21version2.dto.OrderDto;
import com.hillel.lesson30.hw21version2.dto.ProductDto;
import com.hillel.lesson30.hw21version2.entity.Order;
import com.hillel.lesson30.hw21version2.entity.Product;
import com.hillel.lesson30.hw21version2.repository.OrderRepository;
import com.hillel.lesson30.hw21version2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderDto getById(int id) {
        Order order = orderRepository.findById(id);
        List<Product> products = productRepository.findByOrderId(id);
        return Converter.toOrderDto(order, products);
    }

    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(Converter.toOrderDto(order, productRepository.findByOrderId(order.getId())));
        }
        return orderDtos;
    }

    public OrderDto add(OrderDto orderDto) {
        Order order = Converter.toOrder(orderDto);
        order = orderRepository.save(order);
        List<ProductDto> productDtos = orderDto.getProducts();
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            Product product = Converter.toProduct(order.getId(), productDto);
            productRepository.save(product);
            products.add(product);
        }
        return Converter.toOrderDto(order, products);
    }
}
