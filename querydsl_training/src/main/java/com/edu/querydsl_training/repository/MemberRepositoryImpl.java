package com.edu.querydsl_training.repository;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.domain.QMember;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class MemberRepositoryImpl extends QuerydslRepositorySupport
        implements CustomMemberRepository {

    public MemberRepositoryImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> findAllMember() {
        QMember member = QMember.member;

        JPQLQuery query = from(member);

        return query.fetch();
    }
}
