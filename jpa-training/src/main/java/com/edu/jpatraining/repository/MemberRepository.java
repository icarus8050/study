package com.edu.jpatraining.repository;

import com.edu.jpatraining.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
