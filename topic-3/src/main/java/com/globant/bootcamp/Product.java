package com.globant.bootcamp;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;
    
    void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    BigDecimal getPrice(){
        return this.price;
    }
}
