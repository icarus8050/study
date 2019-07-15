package com.edu.querydsl_training.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 10)
    private String name;

    @Column
    private Long age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamId", updatable = false)
    private Team team;

    @Column
    private Long mentor;

    @Builder
    public Member(String name, Long age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public void changeAge(Long age) {
        this.age = age;
    }
}
