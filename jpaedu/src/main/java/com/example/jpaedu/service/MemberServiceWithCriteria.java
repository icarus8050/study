package com.example.jpaedu.service;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.repository.MemberCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceWithCriteria {

    private final MemberCriteria memberCriteria;

    public List<Member> findByMembers() {
        return memberCriteria.findMembers();
    }
}
