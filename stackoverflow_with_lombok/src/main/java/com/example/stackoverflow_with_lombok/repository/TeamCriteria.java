package com.example.stackoverflow_with_lombok.repository;

import com.example.stackoverflow_with_lombok.domain.Team;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
