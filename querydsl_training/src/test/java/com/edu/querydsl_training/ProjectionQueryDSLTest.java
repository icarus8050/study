package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.MemberDTO;
import com.edu.querydsl_training.domain.QMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProjectionQueryDSLTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    @Test
    public void simpleProjectionTest() {
        QMember m = QMember.member;

        query.select(Projections.bean(MemberDTO.class, m.name, m.age.as("age")))
                .from(m)
                .fetch()
                .stream()
                .forEach(memberDTO -> {
                    log.info("member name : " + memberDTO.getName());
                    log.info("member age : " + memberDTO.getAge());
                });
    }

    @Test
    public void simpleProjectionTest_2() {
        QMember m = QMember.member;

        query.select(Projections.fields(MemberDTO.class, m.name, m.age))
                .from(m)
                .fetch()
                .stream()
                .forEach(memberDTO -> {
                    log.info("member name : " + memberDTO.getName());
                    log.info("member age : " + memberDTO.getAge());
                });
    }

    @Test
    public void simpleProjectionTest_3() {
        QMember m = QMember.member;

        query.select(Projections.constructor(MemberDTO.class, m.name, m.age))
                .from(m)
                .fetch()
                .stream()
                .forEach(value -> {
                    log.info("member name : " + value.getName());
                    log.info("member age : " + value.getAge());
                });
    }
}
