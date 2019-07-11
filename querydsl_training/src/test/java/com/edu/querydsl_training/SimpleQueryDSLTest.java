package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.domain.QMember;
import com.edu.querydsl_training.domain.QTeam;
import com.edu.querydsl_training.domain.Team;
import com.edu.querydsl_training.repository.MemberRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleQueryDSLTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void simpleQueryDSL() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QMember qMember = new QMember("m");

        Member member = query.selectFrom(qMember)
                .where(qMember.memberId.eq(1L))
                .fetchOne();

        log.info("member name : " + member.getName());
    }

    @Test
    public void simpleCriteriaQuery() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> root = query.from(Member.class);
        query.select(root).where(builder.equal(root.get("memberId"), 1L));

        Member member = em.createQuery(query).getSingleResult();

        log.info("member name : " + member.getName());
    }

    @Test
    public void simpleQueryDSL_2() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QMember qMember = new QMember("m");
        QTeam qTeam = new QTeam("t");

        List<Member> members = query.selectFrom(qMember)
                .innerJoin(qMember.team, qTeam).fetchJoin()
                .where(qMember.age.goe(30))
                .orderBy(qMember.age.asc())
                .fetch();

        for (Member member : members) {
            log.info("member name : " + member.getName());
            log.info("member age : " + member.getAge());
            log.info("member team name : " + member.getTeam().getTeamName());
        }
    }

    @Test
    public void simpleCriteria_2() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> root = query.from(Member.class);
        root.fetch("team", JoinType.INNER);

        query.select(root)
                .where(builder.ge(root.get("age"), 30))
                .orderBy(builder.asc(root.get("age")));

        List<Member> members = em.createQuery(query).getResultList();

        for (Member member : members) {
            log.info("member name : " + member.getName());
            log.info("member age : " + member.getAge());
            log.info("member team name : " + member.getTeam().getTeamName());
        }
    }

    @Test
    public void queryDslRepositoryTest() {
        List<Member> members = memberRepository.findAllMember();

        for (Member member : members) {
            log.info("member name : " + member.getName());
        }
    }
}
