package com.example.jpaedu.service;

import com.example.jpaedu.domain.Team;
import com.example.jpaedu.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
