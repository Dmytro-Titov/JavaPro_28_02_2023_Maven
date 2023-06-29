package com.hillel.lesson30.hw21.service;

import com.hillel.lesson30.hw21.model.Order;
import com.hillel.lesson30.hw21.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> getAll() {
        List<Order> orders = jdbcTemplate.query("SELECT * FROM Orders", new BeanPropertyRowMapper<>(Order.class));
        for (Order order : orders) {
            order.setProducts(getAllProductsByOrderId(order.getId()));
        }
        return orders;
    }

    public Order getById(int id) {
        Order order = jdbcTemplate.queryForObject("SELECT * FROM Orders WHERE id=" + id,
                new BeanPropertyRowMapper<>(Order.class));
        if (order != null) {
            order.setProducts(getAllProductsByOrderId(id));
        }
        return order;
    }

    public Order getByUsername(String username) {
        Order order = jdbcTemplate.queryForObject("SELECT * FROM Orders WHERE name='" + username + "'",
                new BeanPropertyRowMapper<>(Order.class));
        if (order != null) {
            order.setProducts(getAllProductsByOrderId(order.getId()));
        }
        return order;
    }

    public Order add(Order order) {
        double cost = calculateOrderCost(order);
        jdbcTemplate.update("INSERT INTO Orders VALUES (DEFAULT, ?, ?, ?)",
                order.getName(), order.getDate(), cost);
        return order;
    }

    public List<Product> getAllProductsByOrderId(int orderId) {
        return jdbcTemplate.query("SELECT * FROM Products WHERE order_id=" + orderId,
                new BeanPropertyRowMapper<>(Product.class));
    }

    public List<Product> getAllProductsByUsername(String username) {
        Order order = getByUsername(username);
        return jdbcTemplate.query("SELECT * FROM Products WHERE order_id=" + order.getId(),
                new BeanPropertyRowMapper<>(Product.class));
    }

    public Product addProductToOrder(int orderId, Product product) {
        product.setOrderId(orderId);
        Order order = getById(orderId);
        double orderCost = calculateOrderCost(order) + product.getCost();
        jdbcTemplate.update("INSERT INTO Products VALUES (DEFAULT, ?, ?, ?)",
                product.getName(), product.getCost(), product.getOrderId());
        jdbcTemplate.update("UPDATE Orders SET cost = ? WHERE id = ?", orderCost, orderId);
        return product;
    }

    private double calculateOrderCost(Order order) {
        List<Product> products = order.getProducts();
        if (products == null || products.isEmpty()) {
            return 0.0;
        } else {
            double productsCost = 0.0;
            for (Product product : products) {
                productsCost += product.getCost();
            }
            return productsCost;
        }
    }

}
