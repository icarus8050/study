package com.example.jpaedu.controller;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.domain.Team;
import com.example.jpaedu.service.MemberService;
import com.example.jpaedu.service.MemberServiceWithCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final MemberService memberService;
    private final MemberServiceWithCriteria memberServiceWithCriteria;

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

    @PostMapping("/signup")
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        Member joinedMember = memberService.signUp(member.getName(), member.getAge());
        return new ResponseEntity<>(joinedMember, HttpStatus.OK);
    }

    @GetMapping("/find")
    @ResponseBody
    public Member find(Long id) {
        return memberService.find(id);
    }

    @GetMapping("/findmemberteam")
    @ResponseBody
    public Team findteam(Long id) {
        Member member = memberService.find(id);
        return member.getTeam();
    }

    @GetMapping("/findbyusername")
    @ResponseBody
    public Member findByUserName(String name) {
        return memberService.findByUserName(name);
    }

    @GetMapping("/getmembers")
    @ResponseBody
    public List<Member> findByMembers() {
        return memberServiceWithCriteria.findByMembers();
    }
}
