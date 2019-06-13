package com.example.stackoverflow_with_lombok.repository;

import com.example.stackoverflow_with_lombok.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public class MemberCriteria {

    @PersistenceContext
    EntityManager entityManager;

    //JPQL : select m from Member m
    public List<Member> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);

        Root<Member> m = criteriaQuery.from(Member.class);
        criteriaQuery.select(m);

        TypedQuery<Member> query = entityManager.createQuery(criteriaQuery);
        List<Member> members = query.getResultList();
        return members;
    }

    @Transactional(readOnly = true)
    public List<Member> findMembersLessThanAge(@NotNull Long age) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> root = criteria.from(Member.class);

        Predicate memberIdEqual = builder.lessThan(root.get("age"), age);

        criteria.select(root).where(memberIdEqual);
        List<Member> resultList = entityManager.createQuery(criteria).getResultList();

        return resultList;
    }
}
