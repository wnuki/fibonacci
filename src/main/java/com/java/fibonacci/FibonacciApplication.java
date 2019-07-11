package com.java.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FibonacciApplication {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(FibonacciApplication.class, args);
        Time time = new Time();
        time.countTime();
    }
}
