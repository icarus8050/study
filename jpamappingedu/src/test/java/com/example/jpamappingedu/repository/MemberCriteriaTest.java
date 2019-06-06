package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class MemberCriteriaTest {

    @Autowired
    MemberCriteria memberCriteria;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void findAllTest() {
        List<Member> members = memberCriteria.findAll();

        for (int i = 0; i < members.size(); i++) {
            log.info(members.get(i).getName());
        }
    }

    @Test
    void repositorySaveTest() {
        //member 객체도 영속성 객체로 변경이 되네?
        Member member = Member.builder()
                .name("하나")
                .age(15L)
                .build();

        Member saved = memberRepository.save(member);

        log.info(member.getMemberId().toString());
        log.info(member.getClass().toString());
        log.info(saved.getMemberId().toString());
        System.out.println(member.equals(saved));
        System.out.println(member == saved);
    }
}