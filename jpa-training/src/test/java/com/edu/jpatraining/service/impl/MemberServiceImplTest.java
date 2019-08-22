package com.edu.jpatraining.service.impl;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Test
    public void dirtyCheckTest() {
        memberService.changeAge(1L, 100);
    }
}