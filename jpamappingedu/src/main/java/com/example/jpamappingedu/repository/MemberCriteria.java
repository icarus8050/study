package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
}
