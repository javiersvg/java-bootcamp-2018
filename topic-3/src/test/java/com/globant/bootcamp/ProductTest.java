package com.globant.bootcamp;

import java.math.BigDecimal;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductTest {
    
    @Test
    public void shouldStorePrice() {
        Product product = new Product();
        product.setPrice(new BigDecimal(12));
        assertThat(product.getPrice(), is(new BigDecimal(12)));
    }
}
