package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class TeamCriteria {

    @PersistenceContext
    EntityManager entityManager;

    public List<Team> findByChildList(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Team> query = builder.createQuery(Team.class);

        Root<Team> parent = query.from(Team.class);

        query.select(parent).where(builder.equal(parent.get("parentId"), id));

        return entityManager.createQuery(query).getResultList();
    }

    public Team findById(Long id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Team> query = builder.createQuery(Team.class);

        Root<Team> root = query.from(Team.class);

        query.select(root).where(builder.equal(root.get("id"), id));

        return entityManager.createQuery(query).getSingleResult();
    }
}
