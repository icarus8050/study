package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
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

        /* 이렇게도 가능하다 */
        //Predicate userAgeGreater = cb.gt(m.<Long>get("age"), 30);

        Order ageDesc = cb.desc(m.get("age"));

        cq.select(m).where(userAgeGreater).orderBy(ageDesc);

        List<Member> resultList = entityManager.createQuery(cq).getResultList();

        for (Member member : resultList) {
            log.info("name : " + member.getName());
            log.info("age : " + member.getAge());
        }
    }

    @Test
    void simpleWhereTest() {
        /* 검색 조건에 걸리지 않으면 resultList는
         null이 아닌 size가 0인 List로 반환된다. */
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        Root<Member> m = query.from(Member.class);

        Predicate overAge = builder.gt(m.get("age"), 50);

        query.select(m).where(overAge);
        TypedQuery<Member> typedQuery = entityManager.createQuery(query);

        List<Member> resultList = typedQuery.getResultList();

        System.out.println(resultList.size());
    }

    @Test
    void simpleMultiSelect() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

        Root<Member> m = cq.from(Member.class);

        cq.multiselect(m.get("name"), m.get("age")).distinct(true);
        /* 위와 같은 코드 */
        //cq.select(cb.array(m.get("name"), m.get("age"))).distinct(true);

        TypedQuery<Object[]> query = entityManager.createQuery(cq);

        List<Object[]> resultList = query.getResultList();

        for (Object[] o : resultList) {
            log.info("name " + o[0]);
            log.info("age " + o[1]);
        }
    }

    @Test
    void simpleTuple() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        /* 위와 같은 코드 */
        //CriteriaQuery<Tu|ple> cq = cb.createQuery(Tuple.class);

        Root<Member> m = cq.from(Member.class);
        cq.multiselect(
                m.get("name").alias("userName"),
                m.get("age").alias("age")
        );

        TypedQuery<Tuple> query = entityManager.createQuery(cq);
        List<Tuple> reulstList = query.getResultList();

        for (Tuple t : reulstList) {
            String userName = t.get("userName", String.class);
            Long age = t.get("age", Long.class);

            log.info("name : " + userName);
            log.info("age : " + age);
        }
    }
}
