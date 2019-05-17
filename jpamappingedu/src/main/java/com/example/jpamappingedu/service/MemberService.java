package com.example.jpamappingedu.service;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.repository.MemberCriteria;
import com.example.jpamappingedu.repository.MemberRepository;
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
}
