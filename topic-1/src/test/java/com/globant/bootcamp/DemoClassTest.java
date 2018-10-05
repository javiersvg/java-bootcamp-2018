package com.globant.bootcamp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DemoClassTest {
    
    @Test
    public void test() {
        String result = new DemoClass().salute("Javier");
        assertThat(result, is("Hallo Javier"));
    }
}
