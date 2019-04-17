package com.study.mockitoedu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring Boot2 Mockito2 JUnit5 example")
public class ShowServiceTests {
    private static final String MOCK_OUTPUT = "Mocked show label";

    @Mock
    private TextService textService;
}
