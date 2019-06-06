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
public class Criteria_Test_2 {

    @Autowired
    EntityManager entityManager;

    @Test
    void simpleGroupByTest() {
        //팀 이름 별로 가장 많은 나이와 적은 나이를 구하는 쿼리
        //Cross Join 이 발생한다.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);

        Expression maxAge = cb.max(m.<Long>get("age"));
        Expression minAge = cb.min(m.<Long>get("age"));

        cq.multiselect(m.get("team").get("teamName"), maxAge, minAge);
        cq.groupBy(m.get("team").get("teamName"));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            String teamName = (String) objects[0];
            Long max = (Long) objects[1];
            Long min = (Long) objects[2];

            log.info("Team name : " + teamName);
            log.info("max : " + max);
            log.info("min : " + min);
        }
    }

    @Test
    void simpleHavingTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Member> m = cq.from(Member.class);

        Expression maxAge = cb.max(m.<Long>get("age"));
        Expression minAge = cb.min(m.<Long>get("age"));

        cq.multiselect(m.get("team").get("teamName"), maxAge, minAge)
                .groupBy(m.get("team").get("teamName"))
                .having(cb.gt(minAge, 30))
                .orderBy(cb.desc(maxAge));

        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            String teamName = (String) objects[0];
            Long max = (Long) objects[1];
            Long min = (Long) objects[2];

            log.info("Team name : " + teamName);
            log.info("max : " + max);
            log.info("min : " + min);
        }
    }

    @Test
    void simpleJoinTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member> m = cq.from(Member.class);
        Join<Member, Team> t = m.join("team", JoinType.INNER);

        cq.multiselect(m, t).where(cb.equal(t.get("teamName"), "대한민국"));
        TypedQuery<Object[]> query = entityManager.createQuery(cq);
        List<Object[]> resultList = query.getResultList();

        for (Object[] objects : resultList) {
            Member member = (Member) objects[0];
            Team team = (Team) objects[1];

            log.info(member.getName());
            log.info(team.getTeamName());
        }
    }

    @Test
    void simpleFetchJoinTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);

        m.fetch("team", JoinType.LEFT);

        cq.select(m)
                .where(cb.equal(m.get("team").get("teamName"), "대한민국"))
                .distinct(true);

        TypedQuery<Member> query = entityManager.createQuery(cq);
        List<Member> resultList = query.getResultList();

        for (Member member : resultList) {
            log.info(member.getName());
            log.info(member.getTeam().getTeamName());
        }
    }

    @Test
    void simpleFetchJoinDistinctTest() {
        //JPQL_Test_2.class 의 collectionFetchJoinTest_2() 와 같은
        //결과를 나타내는 Criteria Query

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Team> cq = cb.createQuery(Team.class);

        Root<Team> t = cq.from(Team.class);
        t.fetch("members", JoinType.INNER);

        cq.select(t)
                .where(cb.equal(t.get("id"), 1L))
                .distinct(true);

        TypedQuery<Team> query = entityManager.createQuery(cq);
        List<Team> resultList = query.getResultList();

        for (Team team : resultList) {
            log.info("team name : " + team.getTeamName());

            for (Member member : team.getMembers()) {
                log.info("member name : " + member.getName());
            }
        }
    }
}
