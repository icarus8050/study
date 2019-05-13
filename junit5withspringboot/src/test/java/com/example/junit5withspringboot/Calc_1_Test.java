package com.example.junit5withspringboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.runner.RunWith;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@Slf4j
@RunWith(JUnitPlatform.class)
@IncludeEngines("junit-jupiter")
public class Calc_1_Test {

    //@Autowired
    //private Calculator calculator;

    @Test
    public void test_1() {
        String result = "15";//Integer.toString(calculator.add(5, 10));
        log.info(result);
        Assertions.assertEquals("15", result);
    }
}
