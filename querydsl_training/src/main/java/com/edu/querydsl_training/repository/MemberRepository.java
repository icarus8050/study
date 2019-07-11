package com.edu.querydsl_training.repository;

import com.edu.querydsl_training.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository{
}
