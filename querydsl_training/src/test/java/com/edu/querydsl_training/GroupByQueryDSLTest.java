package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.domain.QMember;
import com.edu.querydsl_training.domain.QTeam;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GroupByQueryDSLTest {

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

        query.select(m.age.avg())
                .from(m)
                .groupBy(m.team)
                .fetch()
                .stream()
                .forEach(value -> {
                    log.info(value.toString());
                });
    }

    /**
     * InnerJoin 의 결과를 GroupBy로 묶어서 집계합수를 실행하는 테스트 코드
     */
    @Test
    public void simpleGroupByTest_2() {
        QMember m = QMember.member;
        QTeam t = QTeam.team;

        List<Tuple> tuples = query.select(m.count(), t.teamName)
                .from(m).innerJoin(m.team, t)
                .groupBy(t)
                .fetch();

        for (Tuple tuple : tuples) {
            log.info("member count : " + tuple.get(m.count()));
            log.info("team name : " + tuple.get(t.teamName));
        }
    }

    /**
     * 팀을 그룹화하여 팀의 평균 나이, 팀의 멤버 수를 구하는 쿼리
     */
    @Test
    public void simpleGroupByTest_3() {
        QMember m = QMember.member;
        QTeam t = QTeam.team;

        query.select(m.age.avg(), m.count(), t.teamName)
                .from(m).innerJoin(m.team, t)
                .groupBy(t)
                .fetch()
                .stream()
                .forEach(tuple -> {
                    log.info("team name : " + tuple.get(t.teamName));
                    log.info("member count : " + tuple.get(1, Long.class));
                    log.info("age avg : " + tuple.get(m.age.avg()));
                });
    }
}
