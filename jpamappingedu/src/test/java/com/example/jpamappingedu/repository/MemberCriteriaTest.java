package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class MemberCriteriaTest {

    @Autowired
    MemberCriteria memberCriteria;

    @Test
    void findAllTest() {
        List<Member> members = memberCriteria.findAll();

        for (int i = 0; i < members.size(); i++) {
            log.info(members.get(i).getName());
        }
    }
}