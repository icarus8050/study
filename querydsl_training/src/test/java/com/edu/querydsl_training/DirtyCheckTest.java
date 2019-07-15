package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.repository.MemberRepository;
import com.edu.querydsl_training.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DirtyCheckTest {

    @Autowired
    MemberService memberService;

    @Transactional
    @Test
    public void simpleDirtyCheckTest() {
        memberService.updateAge(1L, 500L);

        Member member = memberService.findById(1L);

        log.info("name is " + member.getName());
        log.info(("age is " + member.getAge()));
    }
}
