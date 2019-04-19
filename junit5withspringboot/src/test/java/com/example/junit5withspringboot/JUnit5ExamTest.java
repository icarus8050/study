package com.example.junit5withspringboot;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class JUnit5ExamTest {

    @Test
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, () -> "Sum shoud be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {1, 2, 3};
        assertAll("numbersTest",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[1], 2),
                () -> assertEquals(numbers[2], 3)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void assumptionThat() {
        String someString = "Just a string";
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 4)
        );
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("asd");
        });
        assertEquals(exception.getMessage(), "For input string: \"asd\"");
    }

    @Tag("Test case")
    public class TaggedTest {

        @Test
        @Tag("Method")
        void testMethod() {
            assertEquals(2+2, 4);
        }
    }
}
