package org.singleton.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonExample {
    
    private static SingletonExample singletonExample = null;
    
    private SingletonExample(){
    }
    
    public static SingletonExample getInstance(){
        if (singletonExample == null){
            singletonExample = new SingletonExample();
        }
        return singletonExample;
    }
    
    public void sayHello(String [] arg){
        System.out.println("Hello");
    }
}
