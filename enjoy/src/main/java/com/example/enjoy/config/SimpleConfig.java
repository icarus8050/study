package com.example.enjoy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
        @PropertySource(value = "file:C:/Users/Leafy/Desktop/real_db.properties", ignoreResourceNotFound = true)
)
public class SimpleConfig {

    @Value("${aaa.bbb.ccc}")
    private String abc;

    public String getAbc() {
        return this.abc;
    }
}
