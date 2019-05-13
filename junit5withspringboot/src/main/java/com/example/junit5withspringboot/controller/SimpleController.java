package com.example.junit5withspringboot.controller;

import com.example.junit5withspringboot.service.CalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SimpleController {

    private final CalcService calcService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/sample")
    public String sample(@RequestParam int a, @RequestParam int b) {
        return Integer.toString(calcService.add(a, b));
    }
}
