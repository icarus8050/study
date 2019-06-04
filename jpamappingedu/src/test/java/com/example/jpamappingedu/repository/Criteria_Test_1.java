package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
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
public class Criteria_Test_1 {

    @Autowired
    EntityManager entityManager;

    @Test
    void simpleCriteriaTest() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);
        cq.select(m);

        TypedQuery<Member> query = entityManager.createQuery(cq);
        List<Member> memberList = query.getResultList();

        for (Member member : memberList) {
            log.info("name : " + member.getName());
        }
    }

    @Test
    void simpleWhereAndOrderBy() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Member> cq = cb.createQuery(Member.class);

        Root<Member> m = cq.from(Member.class);

        Predicate userAgeGreater = cb.greaterThan(m.get("age"), 30);

        Order ageDesc = cb.desc(m.get("age"));

        cq.select(m).where(userAgeGreater).orderBy(ageDesc);

        List<Member> resultList = entityManager.createQuery(cq).getResultList();

        for (Member member : resultList) {
            log.info("name : " + member.getName());
            log.info("age : " + member.getAge());
        }
    }
}
