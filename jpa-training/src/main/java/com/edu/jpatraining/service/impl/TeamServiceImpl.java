package com.edu.jpatraining.service.impl;

import com.edu.jpatraining.domain.Member;
import com.edu.jpatraining.domain.Team;
import com.edu.jpatraining.repository.TeamRepository;
import com.edu.jpatraining.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    @Transactional(readOnly = true)
    public Team findById(Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id is invalid"));
    }
}
