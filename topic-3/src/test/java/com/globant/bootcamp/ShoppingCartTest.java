package com.globant.bootcamp;

import java.math.BigDecimal;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {
    
    @Test
    public void shouldAddProduct() {
        ShoppingCart cart = new ShoppingCart();
        Product product = mock(Product.class);
        cart.add(product);
        assertThat(cart.getProducts(), contains(product));
    }
    
    @Test
    public void shouldCalculatePrice() {
        ShoppingCart cart = new ShoppingCart();
        Product product = mock(Product.class);
        when(product.getPrice()).thenReturn(new BigDecimal(6));
        cart.add(product);
        cart.add(product);
        assertThat(cart.getPrice(), is(new BigDecimal(12)));
    }
}
