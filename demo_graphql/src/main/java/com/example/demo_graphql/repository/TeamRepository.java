package com.example.demo_graphql.repository;

import com.example.demo_graphql.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
