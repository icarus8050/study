package com.example.stackoverflow_with_lombok.service;

import com.example.stackoverflow_with_lombok.domain.Member;
import com.example.stackoverflow_with_lombok.domain.Team;
import com.example.stackoverflow_with_lombok.repository.TeamCriteria;
import com.example.stackoverflow_with_lombok.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamCriteria teamCriteria;
    private final TeamRepository teamRepository;

    public List<Team> findByChildTeam(Long id) {
        return teamCriteria.findByChildList(id);
    }

    public List<Member> findTeamMembers(Long id) {
        return teamCriteria.findById(id).getMembers();
    }

    public Team findByid(Long id) {
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> findTeams(Long id) {
        return teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team saveTeamAllmembers(Team team) {
        return teamRepository.saveAndFlush(team);
    }
}
