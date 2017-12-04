package com.ist.RentACar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentACarApplication {

    private static final Logger log = LoggerFactory.getLogger(RentACarApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(RentACarApplication.class, args);
    }

}
