package com.example.stackoverflow_with_lombok.repository;

import com.example.stackoverflow_with_lombok.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
