package com.carsharingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSharingApplication {
    private static final Logger log = LoggerFactory.getLogger(CarSharingApplication.class);


    public static void main(String[] args) {
        log.debug("main - start");
        SpringApplication.run(CarSharingApplication.class, args);
    }
}
