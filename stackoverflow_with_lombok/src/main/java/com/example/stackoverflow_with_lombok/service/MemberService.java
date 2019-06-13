package com.example.stackoverflow_with_lombok.service;

import com.example.stackoverflow_with_lombok.domain.Member;
import com.example.stackoverflow_with_lombok.repository.MemberCriteria;
import com.example.stackoverflow_with_lombok.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberCriteria memberCriteria;

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> findMembersLessThanAge(@NotNull Long age) {
        return memberCriteria.findMembersLessThanAge(age);
    }

    public Member update(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        member.changeAge();
        return memberRepository.save(member);
    }
}
