package com.edu.querydsl_training.service;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void updateAge(Long id, Long age) {
        Member member = memberRepository.getOne(id);
        member.changeAge(age);
    }

    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
