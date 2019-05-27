package com.example.demo_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController_2 {

    @GetMapping("/demo_2")
    @ResponseBody
    public String demo_2() {
        return "demo_2";
    }
}
