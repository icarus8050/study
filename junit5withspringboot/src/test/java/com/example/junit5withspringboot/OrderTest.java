package com.example.junit5withspringboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    @Order(1)
    void oneTest() {
        log.info("1 test");
        list.add(10);
        for (Integer num: list) {
            log.info(Integer.toString(num));
        }
    }

    @Test
    @Order(3)
    void threeTest() {
        log.info("3 test");
        for (Integer num: list) {
            log.info(Integer.toString(num));
        }
    }

    @Test
    @Order(5)
    void fiveTest() {
        log.info("5 test");
        for (Integer num: list) {
            log.info(Integer.toString(num));
        }
    }

    @Test
    @Order(2)
    void twoTest() {
        log.info("2 test");
        for (Integer num: list) {
            log.info(Integer.toString(num));
        }
    }

    @Test
    @Order(4)
    void fourTest() {
        log.info("4 test");
        for (Integer num: list) {
            log.info(Integer.toString(num));
        }
    }
}
