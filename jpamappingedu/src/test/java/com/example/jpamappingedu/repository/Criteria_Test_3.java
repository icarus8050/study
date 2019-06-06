package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@DataJpaTest
@Slf4j
public class Criteria_Test_3 {

    @Autowired
    EntityManager entityManager;

    @Test
    void simpleSubqueryTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        //서브 쿼리 생성
        Subquery<Double> subQuery = mainQuery.subquery(Double.class);
        Root<Member> m2 = subQuery.from(Member.class);
        subQuery.select(cb.avg(m2.<Long>get("age")));

        //메인 쿼리 생성
        Root<Member> m = mainQuery.from(Member.class);
        mainQuery.select(m)
                .where(cb.ge(m.<Long>get("age"), subQuery));

        TypedQuery<Member> query = entityManager.createQuery(mainQuery);
        List<Member> members = query.getResultList();

        for (Member member : members) {
            log.info("name : " + member.getName());
            log.info("age : " + member.getAge());
        }
    }

    @Test
    void simpleCorrelateSubqueryTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> mainQuery = cb.createQuery(Member.class);

        //서브 쿼리에서 사용되는 메인 쿼리의 m
        Root<Member> m = mainQuery.from(Member.class);

        //서브 쿼리 생성
        Subquery<Team> subQuery = mainQuery.subquery(Team.class);
        Root<Member> subM = subQuery.correlate(m);

        Join<Member, Team> t = subM.join("team");
        subQuery.select(t).where(cb.equal(t.get("teamName"), "대한민국"));

        //메인 쿼리 생성
        mainQuery.select(m).where(cb.exists(subQuery));

        List<Member> members = entityManager.createQuery(mainQuery).getResultList();

        for (Member member : members) {
            log.info("name : " + member.getName());
        }
    }
}
