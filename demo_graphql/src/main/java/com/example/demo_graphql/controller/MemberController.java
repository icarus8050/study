package com.example.demo_graphql.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/members")
public class MemberController {

    @PostMapping
    public void getAllMembers(@RequestBody String query) {

    }
}
