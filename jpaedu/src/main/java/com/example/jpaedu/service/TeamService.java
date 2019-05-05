package com.example.jpaedu.service;

import com.example.jpaedu.domain.Member;
import com.example.jpaedu.domain.Team;
import com.example.jpaedu.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;

    public Team find(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        log.info("called find : " + team.getName());
        return team;
    }

    //연관관계의 주인이 아닌 경우에는 외래키를 설정할 수 없다.
    public List<Member> joinMember(Long id, Member member) {
        Team team = teamRepository.findById(id).orElse(null);
        team.getMembers().add(member);
        teamRepository.save(team);
        return team.getMembers();
    }
}
