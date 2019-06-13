package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import com.example.jpamappingedu.service.MemberService;
import com.example.jpamappingedu.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class Sample_JPA_Test {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TeamService teamService;

    @Autowired
    EntityManager entityManager;

    @Test
    void injectionTest() {
        Assertions.assertNotNull(entityManager);
    }

    @Test
    void saveMember() {
        Team team = Team.builder()
                .teamName("testTeam")
                .build();

        Member member = Member.builder()
                .age(1L)
                .name("testMember")
                .team(team)
                .build();

        Long memberId = memberService.saveMember(member).getMemberId();

        Member savedMember = memberService.findById(memberId);

        Assertions.assertEquals("testTeam", team.getTeamName());
        Assertions.assertEquals("testMember", savedMember.getName());
    }

    @Test
    void saveMembersTest() {
        Team team = Team.builder()
                .teamName("testTeam")
                .build();

        teamService.saveTeam(team);

        for (int i = 1; i <= 5; i++) {
            Member member = Member.builder()
                    .age(1L)
                    .name("testMember")
                    .team(team)
                    .build();
            memberService.saveMember(member);
        }
    }

    @Test
    void saveTeamAndMembersTest() {
        Team team = Team.builder()
                .teamName("testTeam")
                .build();

        for (int i = 1; i <= 5; i++) {
            Member member = Member.builder()
                    .age(1L)
                    .name("testMember")
                    .team(team)
                    .build();

            team.getMembers().add(member);
        }

        teamService.saveTeam(team);
    }

    @Test
    void saveTeamTest() {
        Team team = Team.builder()
                .teamName("testTeam")
                .build();

        teamService.saveTeam(team);
        Long teamId = team.getId();

        Team team1 = teamService.findByid(teamId);

        teamService.saveTeam(team1);
        System.out.println(team1.getTeamName());
        System.out.println(team.equals(team1));
    }

    @Test
    void findTeamMembers() {
        Team team = teamService.findByid(1L);

        for(Member m : team.getMembers()) {
            log.info("name is.." + m.getName());
        }
    }
}
