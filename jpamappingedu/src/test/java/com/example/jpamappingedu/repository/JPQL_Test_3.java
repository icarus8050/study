package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
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
    void simpleExistsTest() {
        String jpql = "select m from Member m " +
                "where exists (select t from m.team t where t.teamName = '대한민국')";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);

        List<Member> resultList = query.getResultList();

        for (Member m : resultList) {
            log.info("name : " + m.getName());
        }
    }
}
