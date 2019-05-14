package com.example.jpamappingedu.service;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
