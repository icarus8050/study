package com.example.enjoy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DatabaseConnectionTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void entityInitTest() {
        Assertions.assertNotNull(entityManager);
    }
}
