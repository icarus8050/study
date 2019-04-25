package com.example.jpaedu.repository;

import com.example.jpaedu.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReposiroty extends JpaRepository<Member, Long> {
}
