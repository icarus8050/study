package com.example.junit5withspringboot.controller;

import com.example.junit5withspringboot.Domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;

@RestController
public class SimpleController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/sample")
    public String sample() {

    }
}
