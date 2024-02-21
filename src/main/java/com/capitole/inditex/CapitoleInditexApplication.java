package com.capitole.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.capitole.inditex")
@EntityScan(basePackages = "com.capitole.inditex.domain.model")
public class CapitoleInditexApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapitoleInditexApplication.class, args);
    }

}

