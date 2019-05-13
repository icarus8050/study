package com.example.junit5withspringboot;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({
    Calc_1_Test.class, Calc_2_Test.class
})
public class SuiteTest {
}
