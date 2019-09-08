package com.edu.jpatraining.service.impl;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.domain.request.ModifyMemberDto;
import com.edu.jpatraining.repository.MemberRepository;
import com.edu.jpatraining.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    @Cacheable(value = "findMemberCache", key = "#id")
    public Member findById(Long id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
    }

    @Override
    @Transactional
    @CacheEvict(value = "findMemberCache", key = "#id")
    public Member modifyMember(Long id, ModifyMemberDto modifyMemberDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));

        member.modifyMember(modifyMemberDto.getName(), modifyMemberDto.getAge());
        return member;
    }
}
