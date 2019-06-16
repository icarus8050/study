package com.example.enjoy.controller;

import com.example.enjoy.config.SimpleConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingTestController {

    @Autowired
    private SimpleConfig simpleConfig;

    @GetMapping(value = "/test")
    @ResponseBody
    public String settingTest() {
        return simpleConfig.getAbc();
    }
}
