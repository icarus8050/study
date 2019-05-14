package com.example.junit5withspringboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @Test
    @Order(1)
    void oneTest() {
        log.info("1 test");
    }

    @Test
    @Order(3)
    void threeTest() {
        log.info("3 test");
    }

    @Test
    @Order(5)
    void fiveTest() {
        log.info("5 test");
    }

    @Test
    @Order(2)
    void twoTest() {
        log.info("2 test");
    }

    @Test
    @Order(4)
    void fourTest() {
        log.info("4 test");
    }
}
