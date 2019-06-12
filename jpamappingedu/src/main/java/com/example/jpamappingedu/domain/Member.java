package com.example.jpamappingedu.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    public Member(String name, Long age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TEAM_ID")
    @JsonBackReference
    private Team team;

    public void changeAge() {
        age = 100L;
    }

    @Embedded
    private Address address;
}
