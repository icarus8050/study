package com.example.jpamappingedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpamappingeduApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpamappingeduApplication.class, args);
    }

}
