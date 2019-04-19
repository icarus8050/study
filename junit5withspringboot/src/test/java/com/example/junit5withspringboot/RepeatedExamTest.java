package com.example.junit5withspringboot;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedExamTest {

    @RepeatedTest(value = 3, name = "Custom name {currentRepetition}/{totalRepetitions}")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
        assertEquals(2, Math.addExact(1, 1), "1 + 1 equals 2");
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("Before Each Test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("after Each Test");
        System.out.println("---------------------");
    }
}
