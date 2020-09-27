package com.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Point of entry when the web services has been deployed
 */
@SpringBootApplication
public class EmailValidator {
    public static void main(String[] args) {
        SpringApplication.run(EmailValidator.class, args);
    }
    
}
