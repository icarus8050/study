package com.example.jpamappingedu.service;

import com.example.jpamappingedu.domain.Team;
import com.example.jpamappingedu.repository.TeamCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamCriteria teamCriteria;

    public List<Team> findByChildTeam(Long id) {
        return teamCriteria.findByChildList(id);
    }
}
