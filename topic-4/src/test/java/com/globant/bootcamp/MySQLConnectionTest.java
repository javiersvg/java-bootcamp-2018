package com.globant.bootcamp;

import org.junit.Test;

public class MySQLConnectionTest {
    
    @Test
    public void shouldRunQuery() {
        new MySQLConnection().run("select * from pet;");
    }
}
