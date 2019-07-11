package com.edu.querydsl_training.repository;

import com.edu.querydsl_training.domain.Member;

import java.util.List;

public interface CustomMemberRepository {
    List<Member> findAllMember();
}
