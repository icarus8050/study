package com.edu.querydsl_training.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column(length = 20)
    private String teamName;

    @Column
    private Long awardCount;

    @Builder
    public Team(String teamName, Long awardCount) {
        this.teamName = teamName;
        this.awardCount = awardCount;
    }
}

