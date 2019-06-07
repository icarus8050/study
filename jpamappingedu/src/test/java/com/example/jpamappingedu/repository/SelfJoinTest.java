package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.SelfEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@DataJpaTest
@Slf4j
public class SelfJoinTest {

    @Autowired
    EntityManager entityManager;

    @Deprecated
    @Test
    void selfJoinTest() {
        /* 연관관계 없이 필드만으로 부모를 가르키는 구조는 Join 불가능 */
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<SelfEntity> cq = cb.createQuery(SelfEntity.class);

        Root<SelfEntity> s = cq.from(SelfEntity.class);
        Join<SelfEntity, SelfEntity> c = s.join("parentId");
        c.on(c.get("parentId"));

        cq.select(c).where(cb.equal(c.get("parentId"), 1));
        TypedQuery<SelfEntity> query = entityManager.createQuery(cq);

        List<SelfEntity> selfEntities = query.getResultList();

        for (SelfEntity selfEntity : selfEntities) {
            log.info("name : " + selfEntity.getName());
        }
    }
}
