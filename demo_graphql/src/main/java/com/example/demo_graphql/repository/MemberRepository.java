package com.example.demo_graphql.repository;

import com.example.demo_graphql.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
