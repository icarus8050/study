package com.example.stackoverflow_with_lombok.repository;

import com.example.stackoverflow_with_lombok.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
