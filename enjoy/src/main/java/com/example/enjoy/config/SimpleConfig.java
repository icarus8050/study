package com.example.enjoy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

    @Value("${aaa.bbb.ccc}")
    private String abc;

    public String getAbc() {
        return this.abc;
    }
}
