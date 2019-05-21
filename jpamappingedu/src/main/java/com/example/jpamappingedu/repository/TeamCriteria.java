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
        Join<Team, Team> children = parent.join("parentTeam", JoinType.INNER);

        query.select(parent).where(builder.equal(parent.get("id"), id));

        return entityManager.createQuery(query).getResultList();
    }
}
