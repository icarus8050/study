package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.Member;
import com.edu.querydsl_training.domain.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Transactional
public class MutationQueryDSLTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    @Test
    public void simpleUpdateTest() {
        QMember m = QMember.member;

        Long count = query.update(m)
                .set(m.name, "IU")
                .where(m.memberId.eq(1L))
                .execute();

        log.info("count is : " + count.toString());

        Member member = query.selectFrom(m).where(m.memberId.eq(1L)).fetchOne();
        log.info("name is : " + member.getName());
    }

    @Test
    public void bulkUpdateTest() {
        QMember m = QMember.member;

        query.update(m)
                .set(m.age, m.age.add(100L))
                .where(m.age.goe(30))
                .execute();

        query.selectFrom(m)
                .where(m.age.goe(100L))
                .orderBy(m.age.asc())
                .fetch()
                .stream()
                .forEach(member -> {
                    log.info("name is " + member.getName());
                    log.info("age is " + member.getAge());
                });
    }

    @Test
    public void simpleDeleteTest() {
        QMember m = QMember.member;

        query.delete(m).where(m.memberId.eq(1L)).execute();

        Member deleted = query.selectFrom(m).where(m.memberId.eq(1L)).fetchOne();
        assertThat(deleted, is(nullValue()));
    }

    @Test
    public void bulkDeleteTest() {
        QMember m = QMember.member;

        query.delete(m).where(m.memberId.loe(5)).execute();

        List<Member> members = query.selectFrom(m).where(m.memberId.loe(5)).fetch();
        assertThat(members.size(), is(0));
    }
}
