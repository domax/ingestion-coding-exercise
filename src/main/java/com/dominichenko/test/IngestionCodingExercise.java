package com.dominichenko.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author <a href="mailto:max@dominichenko.com">Max Dominichenko</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class IngestionCodingExercise {

    public static void main(String[] args) {
        SpringApplication.run(IngestionCodingExercise.class, args);
    }
}
