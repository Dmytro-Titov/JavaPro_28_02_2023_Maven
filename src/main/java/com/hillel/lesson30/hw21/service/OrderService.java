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
                .cost(0.0)
                .products(new ArrayList<>())
                .build());
        orders.add(Order.builder()
                .id(2)
                .date(LocalDate.of(2022, 10, 15))
                .cost(0.0)
                .products(new ArrayList<>())
                .build());
        orders.add(Order.builder()
                .id(3)
                .date(LocalDate.of(2023, 6, 14))
                .cost(0.0)
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
        double sum = calculateCost(order);
        order.setCost(sum);
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
                order.setCost(calculateCost(updatedOrder));
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
        order.setCost(order.getCost() + product.getCost());
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
                order.setCost(order.getCost() - product.getCost());
                products.remove(product);
            }
        }
        return removedProduct;
    }

    public Product updateProduct(int orderId, Product newProduct) {
        Order order = getById(orderId);
        List<Product> products = order.getProducts();
        for (Product oldProduct : products) {
            if (oldProduct.getId() == newProduct.getId()) {
                order.setCost(order.getCost() - oldProduct.getCost() + newProduct.getCost());
                oldProduct.setName(newProduct.getName());
                oldProduct.setCost(newProduct.getCost());
            }
        }
        return newProduct;
    }
    private double calculateCost(Order order) {
        List<Product> products = order.getProducts();
        double sum = 0.0;
        if (!products.isEmpty()) {
            for (Product product : products) {
                sum += product.getCost();
            }
        } return sum;
    }

}
