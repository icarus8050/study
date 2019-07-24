package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

    /**
     * 조인을 사용하지 않고 1L 팀에 속한 멤버 리스트 조회하기
     */
    @Test
    public void memberSearchWithteamId() {
        QMember member = QMember.member;

        query.select(member)
                .from(member)
                .where(member.team.teamId.eq(1L))
                .fetch()
                .stream()
                .forEach(m -> {
                    log.info("name is : " + m.getName());
                });
    }

    /**
     * 조인을 사용하지 않고 1L 팀에 속한 멤버 리스트 조회하기
     */
    @Test
    public void memberSearchWithTeamId() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> from = query.from(Member.class);

        query.select(from)
                .where(builder.equal(from.get("team").get("teamId"), 1L));
        em.createQuery(query)
                .getResultList()
                .stream()
                .forEach(member -> {
                    log.info("name is : " + member.getName());
                });
    }
}
