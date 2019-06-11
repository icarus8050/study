package com.example.demo_graphql.service;

import com.example.demo_graphql.domain.Team;
import com.example.demo_graphql.repository.TeamRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;

@Service
@Transactional
@RequiredArgsConstructor
@GraphQLApi
public class TeamService {

    private final TeamRepository teamRepository;

    @GraphQLQuery(name = "team")
    public Team findById(@NotNull @GraphQLArgument(name = "id") Long id) {
        return teamRepository.findById(id).orElse(null);
    }
}
