package com.example.jpamappingedu.controller;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/findById")
    @ResponseBody
    public Member findById(Long id) {
        return memberService.findById(id);
    }

    @GetMapping("/saveMember")
    @ResponseBody
    public Member saveMember(String name, Long age) {
        return memberService.saveMember(
                Member.builder().name(name).age(age).build()
        );
    }

    @GetMapping("/findByMembersLessThanAge")
    @ResponseBody
    public List<Member> findByMembersLessThanAge(Long age) {
        return memberService.findMembersLessThanAge(age);
    }

    @GetMapping("/changeAge")
    @ResponseBody
    public Member changeAge(Long id) {
        return memberService.update(id);
    }
}
