package com.edu.jpatraining.controller;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.domain.request.ModifyMemberDto;
import com.edu.jpatraining.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    @ResponseBody
    public Member getMember(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Member modifyMember(@PathVariable Long id, @RequestBody ModifyMemberDto modifyMemberDto) {
        return memberService.modifyMember(id, modifyMemberDto);
    }
}
