package com.example.jpamappingedu.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    private Team parentTeam;*/

    private Long parentId;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private List<Member> members;
}
