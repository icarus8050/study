package com.example.jpaedu.repository;

import com.example.jpaedu.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberReposiroty extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.name = :name")
    Member findByUserName(@Param("name") String username);
}
