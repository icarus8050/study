package com.example.jpamappingedu.service;

import com.example.jpamappingedu.domain.Member;
import com.example.jpamappingedu.domain.Team;
import com.example.jpamappingedu.repository.TeamCriteria;
import com.example.jpamappingedu.repository.TeamRepository;
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
}
