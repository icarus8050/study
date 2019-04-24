package com.example.jpaedu.controller;

import com.example.jpaedu.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello2")
    public ResponseEntity<Member> hello2() {
        Member member = Member.builder()
                .id(Long.valueOf(4))
                .name("독일")
                .age(Integer.valueOf(39))
                .build();

        return new ResponseEntity<>(member, HttpStatus.OK);
    }
}
