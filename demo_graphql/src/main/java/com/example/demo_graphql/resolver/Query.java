package com.example.demo_graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo_graphql.domain.Member;
import com.example.demo_graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final MemberRepository memberRepository;

    public Iterable<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Long countMembers() {
        return memberRepository.count();
    }
}
