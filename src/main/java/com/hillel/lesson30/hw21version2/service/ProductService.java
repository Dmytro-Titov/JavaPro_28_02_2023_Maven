package com.hillel.lesson30.hw21version2.service;

import com.hillel.lesson30.hw21version2.Converter;
import com.hillel.lesson30.hw21version2.dto.ProductDto;
import com.hillel.lesson30.hw21version2.entity.Product;
import com.hillel.lesson30.hw21version2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto addToOrder(int orderId, ProductDto productDto) {
        Product product = Converter.toProduct(orderId, productDto);
        Product savedProduct = productRepository.save(product);
        productDto.setId(savedProduct.getId());
        return productDto;
    }
}
