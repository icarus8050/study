package com.example.demo_graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo_graphql.domain.Member;
import com.example.demo_graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final MemberRepository memberRepository;

    public Member newMember(String name, Long age) {
        Member member = Member.builder().name(name).age(age).build();
        return memberRepository.save(member);
    }
}
