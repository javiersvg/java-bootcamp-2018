package com.globant.bootcamp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> products = new ArrayList<>();
    
    void add(Product product) {
        this.products.add(product);
    }
    
    List<Product> getProducts() {
        return this.products;
    }
    
    BigDecimal getPrice() {
        return this.products.stream().map(p -> p.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
