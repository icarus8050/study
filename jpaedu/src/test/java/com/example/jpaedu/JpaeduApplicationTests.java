package com.example.jpaedu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JpaeduApplicationTests {

    @Test
    public void contextLoads() {
        Assertions.assertNotNull("aaa");
    }

}
