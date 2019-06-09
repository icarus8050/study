package com.example.demo_graphql.query;

import com.example.demo_graphql.domain.Member;
import com.example.demo_graphql.repository.MemberRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQuery {

    private final MemberRepository memberRepository;

    @GraphQLQuery(name = "findMemberById")
    public Member getGreeting(@GraphQLArgument(name = "id", description = "Member to greet")
                              final Long idx) {
        return memberRepository.findById(idx).orElse(null);
    }
}
