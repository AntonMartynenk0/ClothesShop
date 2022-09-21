package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Demo1Application.class);

        SpringApplication.run(Demo1Application.class, args);
    }
}
