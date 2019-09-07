package com.edu.jpatraining.controller;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.domain.request.ModifyMemberDto;
import com.edu.jpatraining.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    @ResponseBody
    public Member getMember(@PathVariable Long id) {
        Member member = memberService.findById(id);
        return member;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Member modifyMember(@PathVariable Long id, @RequestBody ModifyMemberDto modifyMemberDto) {
        Member member = memberService.modifyMember(id, modifyMemberDto);
        log.info("entity lifecycle : " + member.getTeam().getName());
        return member;
    }
}
