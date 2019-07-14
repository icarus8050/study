package com.edu.querydsl_training;

import com.edu.querydsl_training.domain.QMember;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static com.edu.querydsl_training.domain.QMember.member;
import static com.edu.querydsl_training.domain.QTeam.team;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DynamicQueryTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory query;

    @Before
    public void setUp() {
        query = new JPAQueryFactory(em);
    }

    @Test
    public void simpleDynamicQuery() {
        QMember m = QMember.member;

        String name = "아이유";
        Long age = 20L;

        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.hasText(name)) {
            builder.and(m.name.eq(name));
        }

        if (age != null) {
            builder.and(m.age.goe(age));
        }

        query.selectFrom(m).where(builder).fetch()
                .stream()
                .forEach(result -> {
                    log.info("name is " + result.getName());
                    log.info("age is " + result.getAge());
                });
    }

    @Test
    public void booleanExpressionDynamicTest() {
        String name = "아이유";
        Long age = 20L;

        query.selectFrom(member).where(eqName(name), goeAge(age)).fetch()
                .stream()
                .forEach(result -> {
                    log.info("name is " + result.getName());
                    log.info("age is " + result.getAge());
                });
    }

    private BooleanExpression eqName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        return member.name.eq(name);
    }

    private BooleanExpression goeAge(Long age) {
        if (age == null) {
            return null;
        }
        return member.age.goe(age);
    }
}
