package com.example.jpaedu.service;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.repository.MemberReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberReposiroty memberReposiroty;

    public Member signUp(String name, Integer age) {
        Member memberInfo = Member.builder()
                .name(name)
                .age(age)
                .build();
        return memberReposiroty.save(memberInfo);
    }

    public Member find(Long id) {
        return memberReposiroty.findById(id).orElse(null);
    }
}
