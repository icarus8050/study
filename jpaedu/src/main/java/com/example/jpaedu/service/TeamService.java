package com.example.jpaedu.service;

import com.example.jpaedu.domain.Team;
import com.example.jpaedu.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team find(Long id) {
        return teamRepository.findById(id).orElse(null);
    }
}
