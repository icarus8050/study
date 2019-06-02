package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@DataJpaTest
@Slf4j
public class JPQL_Test_2 {

    @Autowired
    EntityManager entityManager;


    @Test
    void simpleJoinTest() {
        Query query = entityManager.createQuery("select m, t from Member m join m.team t");
        List resultList = query.getResultList();

        for (Object o : resultList) {
            Object[] result = (Object[]) o;
            Member member = (Member) result[0];
            Team team = (Team) result[1];

            log.info("member name : " + member.getName());
            log.info("team name : " + team.getTeamName());
        }
    }

    @Test
    void simpleLeftJoinTest() {
        TypedQuery<Member> query =
                entityManager.createQuery("select m from Member m left join m.team t", Member.class);
        List<Member> resultList = query.getResultList();

       for (Member m : resultList) {
            log.info("member name : " + m.getName());
            /*if (m.getTeam() != null)
                log.info("team name : " + m.getTeam().getTeamName());*/
        }
    }

    @Test
    void searchChildTeamTest() {
        String jpql = "select t.teams from Team t where t.id = 1";
        Query query = entityManager.createQuery(jpql);
        List<Team> result = query.getResultList();

        Iterator<Team> iter = result.iterator();

        while(iter.hasNext()) {
            Team team = iter.next();
            log.info(team.getTeamName());
        }
        /*List<Team> resultList = query.getResultList();

        for (Team team : resultList) {
            log.info("team name : " + team.getTeamName());
        }*/
    }

    @Test
    void simpleFetchJoinTest() {
        String jpql = "select m from Member m join fetch m.team";
        TypedQuery<Member> query = entityManager
                .createQuery(jpql, Member.class);

        List<Member> resultList = query.getResultList();

        for (Member m : resultList) {
            log.info("member name : " + m.getName());
            log.info("team name : " + m.getTeam().getTeamName());
        }
    }
}
