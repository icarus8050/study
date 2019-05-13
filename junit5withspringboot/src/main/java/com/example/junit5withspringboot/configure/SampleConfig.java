package com.example.junit5withspringboot.configure;

import com.example.junit5withspringboot.configure.bean.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class SampleConfig {

    @Bean
    public Calculator calculator() {
        log.info("calculator!");
        return new Calculator();
    }
}
