package com.edu.jpatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaTrainingApplication.class, args);
    }

}
