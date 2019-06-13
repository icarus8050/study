package com.example.stackoverflow_with_lombok.service;

import com.example.stackoverflow_with_lombok.domain.Member;
import com.example.stackoverflow_with_lombok.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TeamServiceTest {

    @Autowired
    TeamService teamService;

    @Test
    public void saveTeamAllMembersTest() {
        Team team = new Team();
        team.setTeamName("testTeam");

        List<Member> members = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            members.add(
                    Member.builder()
                    .name("member_" + i)
                    .age(14L)
                    .team(team)
                    .build()
            );
        }
        team.addAllMembers(members);

        teamService.saveTeamAllmembers(team);
        log.info(team.toString());
    }
}