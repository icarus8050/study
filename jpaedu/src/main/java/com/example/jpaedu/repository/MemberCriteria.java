package com.example.jpaedu.repository;

import com.example.jpaedu.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MemberCriteria {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        //Select
        CriteriaQuery<Member> query = builder.createQuery(Member.class);

        //From
        Root<Member> root = query.from(Member.class);

        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}
