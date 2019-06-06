package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@DataJpaTest
@Slf4j
public class JPQL_Test_3 {

    @Autowired
    EntityManager entityManager;

    @Test
    void simpleSubQueryTest() {
        String jpql = "select m from Member m " +
                "where m.age > (select avg(m2.age) from Member m2)";

        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);

        List<Member> resultList = query.getResultList();

        for (Member m : resultList) {
            log.info("name : " + m.getName());
            log.info("age : " + m.getAge());
            log.info("----------------------");
        }
    }

    @Test
    void simpleSubQueryTest_2() {
        String jpql = "select m from Member m " +
                "where m.team.teamName = '대한민국' and " +
                "m.age >= (select avg(m2.age) from Member m2 where m2.team.teamName = '대한민국')";

        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);

        List<Member> resultList = query.getResultList();

        for (Member m : resultList) {
            log.info("name : " + m.getName());
            log.info("age : " + m.getAge());
            log.info("----------------------");
        }
    }

    @Test
    void simpleExistsTest() {
        String jpql = "select m from Member m " +
                "where exists (select t from m.team t where t.teamName = '대한민국')";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);

        List<Member> resultList = query.getResultList();

        for (Member m : resultList) {
            log.info("name : " + m.getName());
        }
    }

    @Test
    void simpleInTest() {
        String jpql = "select t from Team t " +
                "where t in (select t2 from Team t2 join t2.members m2 where m2.age >= 30)";
        TypedQuery<Team> query = entityManager.createQuery(jpql,Team.class);

        List<Team> resultList = query.getResultList();

        for (Team t : resultList) {
            log.info("name : " + t.getTeamName());
        }
    }
}
