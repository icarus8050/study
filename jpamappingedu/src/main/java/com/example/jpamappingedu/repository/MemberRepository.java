package com.example.jpamappingedu.repository;

import com.example.jpamappingedu.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
