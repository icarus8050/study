package com.edu.querydsl_training.domain;

import lombok.Builder;
import lombok.Data;
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
    private String name;

    @Column
    private Long awardCount;

    @Builder
    public Team(String name, Long awardCount) {
        this.name = name;
        this.awardCount = awardCount;
    }
}

