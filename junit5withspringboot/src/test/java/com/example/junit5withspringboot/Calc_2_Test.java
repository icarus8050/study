package com.example.junit5withspringboot;

import com.example.junit5withspringboot.configure.bean.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class Calc_2_Test {

    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        String result = Integer.toString(calculator.add(1, 2));
        log.info(result);
        Assertions.assertEquals("3", result);
    }
}
