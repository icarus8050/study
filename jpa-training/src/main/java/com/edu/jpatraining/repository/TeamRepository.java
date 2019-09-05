package com.edu.jpatraining.repository;

import com.edu.jpatraining.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
