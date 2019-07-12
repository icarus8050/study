package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.domain.QMember;
import com.edu.querydsl_training.domain.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ComplicateQueryDSLTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    @Test
    public void pagingAndOrderTest() {
        QMember m = QMember.member;

        List<Member> memberList = query.selectFrom(m)
                .where(m.age.loe(30))
                .orderBy(m.memberId.asc())
                .offset(5).limit(5)
                .fetch();

        for (Member member : memberList) {
            log.info("member Id : " + member.getMemberId());
            log.info("member name : " + member.getName());
            log.info("member age : " + member.getAge());
        }
    }

    @Test
    public void simpleGroupByTest() {
        QMember m = QMember.member;
        QTeam t = QTeam.team;
        query.select(m.age.avg())
                .from(m)
                .groupBy(m.team)
                .fetch()
                .stream()
                .forEach(value -> {
                    log.info(value.toString());
                });
    }
}
