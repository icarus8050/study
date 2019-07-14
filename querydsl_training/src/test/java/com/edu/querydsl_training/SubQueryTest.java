package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.MemberCountDTO;
import com.edu.querydsl_training.domain.QMember;
import com.edu.querydsl_training.domain.QTeam;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
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
public class SubQueryTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    @Test
    public void simpleSubQueryTest() {
        QMember m = QMember.member;
        QTeam t = QTeam.team;

        query.select(Projections.fields(MemberCountDTO.class, t.teamName,
                ExpressionUtils.as(
                        JPAExpressions.select(m.team.count())
                                .from(m)
                                .where(m.team.eq(t)),
                        "memberCount")
        ))
                .from(t)
                .fetch()
                .stream()
                .forEach(result -> {
                    log.info("team name is : " + result.getTeamName());
                    log.info("member count is : " + result.getMemberCount());
                });
    }

    @Test
    public void whereSubQueryTest() {
        QMember m = QMember.member;
        QTeam t = QTeam.team;

        query.selectFrom(t)
                .where(t.teamId.in(
                        JPAExpressions
                                .select(m.team.teamId)
                                .from(m)
                                .where(m.memberId.eq(1L))
                ))
                .fetch()
                .stream()
                .forEach(result -> {
                    log.info("team id is " + result.getTeamId());
                    log.info("team name is " + result.getTeamName());
                });
    }
}
