package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Transactional(readOnly = true)
    public Member findMembersLessThanAge(@NotNull Long age) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Member> criteria = builder.createQuery(Member.class);
        Root<Member> root = criteria.from(Member.class);

        Predicate memberIdEqual = builder.lessThan(root.get("memberId"), age);

        criteria.select(root).where(memberIdEqual);
        List<Member> resultList = entityManager.createQuery(criteria).getResultList();

        return
    }
}
