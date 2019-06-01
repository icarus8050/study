package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class TeamCriteriaTest {

    @Autowired
    TeamCriteria teamCriteria;

    @Test
    void findChildTeamTest() {
        List<Team> teams = teamCriteria.findByChildList(1L);

        for (Team team : teams) {
            log.info("result : " + team.getId());
        }
    }
}
