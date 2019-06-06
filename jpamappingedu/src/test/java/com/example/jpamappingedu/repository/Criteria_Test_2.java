package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
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
                .having(cb.gt(minAge, 30));

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
}
