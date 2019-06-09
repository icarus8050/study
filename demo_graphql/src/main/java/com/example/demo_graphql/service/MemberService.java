package com.example.demo_graphql.service;

import com.example.demo_graphql.domain.Member;
import com.example.demo_graphql.repository.MemberRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @GraphQLQuery(name = "members")
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @GraphQLQuery(name = "member")
    public Member getMemberById(@NotNull @GraphQLArgument(name = "id") Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @GraphQLMutation(name = "saveMember")
    public Member saveMember(@GraphQLArgument(name = "member") Member member) {
        return memberRepository.save(member);
    }

    /*public void deleteMember(@NotNull Long id) {
        memberRepository.deleteById(id);
    }*/
}
