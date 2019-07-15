package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class nonRelationalJoinTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    /**
     * 연관관계 없이 조인하는 쿼리
     * 멘토의 id가 1L 인 사람들을 구하는 쿼리
     */
    @Test
    public void simpleNonRelationJoinTest() {
        QMember member = new QMember("m");
        QMember mentor = new QMember("mentor");

        query.selectFrom(member)
                .join(mentor).on(mentor.memberId.eq(member.mentor))
                .where(mentor.memberId.eq(1L))
                .fetch()
                .stream()
                .forEach(m -> {
                    log.info("name is : " + m.getName());
                });

    }
}
