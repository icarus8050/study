package com.example.jpamappingedu.domain;

import com.example.jpamappingedu.controller.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private Long age;

    @Builder
    public Member(String name, Long age) {
        this.name = name;
        this.age = age;
    }

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public void changeAge() {
        age = 100L;
    }
}
