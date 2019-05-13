package com.example.jpaedu;


import com.example.jpaedu.domain.Member;
import com.example.jpaedu.repository.MemberReposiroty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@Slf4j
public class JpaeduApplicationTests {

    @Autowired
    private MemberReposiroty memberReposiroty;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(" ");
    }

    @Test
    public void repositoryTest() {
        memberReposiroty.save(Member.builder().name("ttt").age(14).build());
        List<Member> memberList = memberReposiroty.findAll();

        memberList.stream().forEach(member -> log.info(member.getName()));
    }
}
