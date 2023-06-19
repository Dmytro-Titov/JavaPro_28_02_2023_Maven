package com.hillel.lesson30.hw21.service;

import com.hillel.lesson30.hw21.model.Order;
import com.hillel.lesson30.hw21.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private static List<Order> orders = new ArrayList<>();

    static {
        orders.add(Order.builder()
                .id(1)
                .date(LocalDate.of(2021, 3, 11))
                .cost(455.0)
                .products(new ArrayList<>())
                .build());
        orders.add(Order.builder()
                .id(2)
                .date(LocalDate.of(2022, 10, 15))
                .cost(600.0)
                .products(new ArrayList<>())
                .build());
        orders.add(Order.builder()
                .id(3)
                .date(LocalDate.of(2023, 6, 14))
                .cost(950.0)
                .products(new ArrayList<>())
                .build());
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order getById(int id) {
        Order result = null;
        for (Order order : orders) {
            if (order.getId() == id) {
                result = order;
            }
        }
        return result;
    }

    public Order addOrder(Order order) {
        int index = orders.size() + 1;
        order.setId(index);
        orders.add(order);
        return order;
    }

    public Order removeOrder(int id) {
        Order order = getById(id);
        orders.remove(order);
        return order;
    }

    public Order updateOrder(Order updatedOrder) {
        for (Order order : orders) {
            if (order.getId() == updatedOrder.getId()) {
                order.setDate(updatedOrder.getDate());
                order.setCost(updatedOrder.getCost());
                order.setProducts(updatedOrder.getProducts());
            }
        }
        return updatedOrder;
    }

    public List<Product> getAllByOrderId(int orderId) {
        Order order = getById(orderId);
        return order.getProducts();
    }

    public Product addProduct(int orderId, Product product) {
        Order order = getById(orderId);
        List<Product> products = order.getProducts();
        int productIndex = products.size() + 1;
        product.setId(productIndex);
        products.add(product);
        order.setProducts(products);
        return product;
    }

    public Product removeProduct(int orderID, int productId) {
        Product removedProduct = null;
        Order order = getById(orderID);
        List<Product> products = order.getProducts();
        for (Product product : products) {
            if (product.getId() == productId) {
                removedProduct = product;
                products.remove(product);
            }
        }
        return removedProduct;
    }

    public Product updateProduct(int orderId, Product product) {
        Order order = getById(orderId);
        List<Product> products = order.getProducts();
        for (Product oldProduct : products) {
            if (oldProduct.getId() == product.getId()) {
                oldProduct.setName(product.getName());
                oldProduct.setCost(product.getCost());
            }
        }
        return product;
    }

}
