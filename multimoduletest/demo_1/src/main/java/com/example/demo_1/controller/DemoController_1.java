package com.example.demo_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController_1 {

    @GetMapping("/demo_1")
    @ResponseBody
    public String demo_1() {
        return "demo_1";
    }
}
