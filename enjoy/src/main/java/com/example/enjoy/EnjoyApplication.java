package com.example.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class EnjoyApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EnjoyApplication.class)
                .properties(
                        "spring.config.location=" +
                                "file:C:/Users/Leafy/Desktop/real_db.yml"
                )
                .run(args);
    }

}
