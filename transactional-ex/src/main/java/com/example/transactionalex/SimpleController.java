package com.example.transactionalex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private AService aService;

    public SimpleController(AService aService) {
        this.aService = aService;
    }

    @GetMapping("/simpleA")
    @ResponseBody
    public String simpleA() {
        aService.simpleA();
        return "simpleA is called";
    }
}
