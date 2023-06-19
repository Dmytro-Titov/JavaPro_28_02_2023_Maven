package com.hillel.lesson30.hw21.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private LocalDate date;
    private double cost;
    private List<Product> products;
}
