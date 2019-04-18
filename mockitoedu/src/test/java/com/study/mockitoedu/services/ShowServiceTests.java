package com.study.mockitoedu.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring Boot2 Mockito2 JUnit5 example")
public class ShowServiceTests {
    private static final String MOCK_OUTPUT = "Mocked show label";

    @Mock
    private TextService textService;

    @InjectMocks
    private ShowService showService;

    @BeforeEach
    void setMockOutput() {
        when(textService.getText()).thenReturn("asd");
    }

    @Test
    @DisplayName("Mock the output of the text service using mockito")
    public void contextLoads() {
        assertEquals(showService.getShowLable(), MOCK_OUTPUT);
    }
}