package com.example.demo_graphql.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter(onMethod = @_(@GraphQLQuery))
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GraphQLQuery(name = "memberId", description = "Member's id")
    private Long memberId;

    //@GraphQLQuery(name = "name", description = "Member's name")
    private String name;

    //@GraphQLQuery(name = "age", description = "Member's age")
    private Long age;

    @Builder
    public Member(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    @JsonBackReference
    //@GraphQLQuery(name = "team", description = "Member's team")
    private Team team;

    public void changeAge() {
        age = 100L;
    }
}
