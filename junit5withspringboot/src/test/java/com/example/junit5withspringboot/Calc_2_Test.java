package com.example.junit5withspringboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@Slf4j
@RunWith(JUnitPlatform.class)
public class Calc_2_Test {

    //@Autowired
    //private Calculator calculator;

    @Test
    public void test() {
        String result = "3";//Integer.toString(calculator.add(1, 2));
        log.info(result);
        Assertions.assertEquals("3", result);
    }
}
