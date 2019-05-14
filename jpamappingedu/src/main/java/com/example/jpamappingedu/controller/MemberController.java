package com.example.jpamappingedu.controller;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/findById")
    @ResponseBody
    public Member findById(Long id) {
        return memberService.findById(id);
    }
}
