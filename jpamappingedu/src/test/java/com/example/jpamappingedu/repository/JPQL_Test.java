package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@DataJpaTest
@Slf4j
public class JPQL_Test {

    @Autowired
    EntityManager entityManager;

    @Test
    void injectionTest() {
        Assertions.assertNotNull(entityManager);
    }

    @Test
    void simpleTest() {
        String jpql = "select m from Member as m where m.name = '아이유'";
        List<Member> result = entityManager.createQuery(jpql, Member.class).getResultList();

        for (Member m : result) {
            log.info(m.getName());
        }
    }

    @Test
    void simpleCriteriaTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> query = cb.createQuery(Member.class);

        //루트 클래스 (조회를 시작할 클래스)
        Root<Member> m = query.from(Member.class);

        //쿼리 생성
        CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("name"), "아이유"));
        List<Member> result = entityManager.createQuery(cq).getResultList();

        for (Member member : result) {
            log.info(member.getName());
        }
    }

    @Test
    void simpleTypeQueryTest() {
        TypedQuery<Member> query = entityManager.createQuery("select m from Member m", Member.class);
        List<Member> result = query.getResultList();

        for (Member m : result) {
            log.info("result : " + m.getName());
        }
    }

    @Test
    void simpleQueryTest() {
        Query query = entityManager.createQuery("select m.name, m.age from Member m");
        List resultList = query.getResultList();

        for (Object o : resultList) {
            Object[] result = (Object[]) o;
            log.info("name : " + result[0]);
            log.info("age : " + result[1]);
        }
    }
}
