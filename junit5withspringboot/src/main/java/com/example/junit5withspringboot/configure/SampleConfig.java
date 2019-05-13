package com.example.junit5withspringboot.configure;

import com.example.junit5withspringboot.configure.bean.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfig {

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }
}
