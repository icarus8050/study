package com.example.stackoverflow_with_lombok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Data
@ToString(exclude = {"team"})
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "memberId", callSuper = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", nullable = false)
    @JsonBackReference
    private Team team;

    public void changeAge() {
        age = 100L;
    }

    @Embedded
    private Address address;
}
