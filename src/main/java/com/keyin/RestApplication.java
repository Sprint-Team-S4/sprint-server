package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EntityScan(basePackages = {"com.keyin.Aircraft", "com.keyin.Airline", "com.keyin.Airport", "com.keyin.City", "com.keyin.Gate", "com.keyin.Passengers", "com.keyin.Flight", "com.keyin.Admin"})
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}