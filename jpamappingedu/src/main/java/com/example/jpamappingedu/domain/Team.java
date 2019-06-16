package com.example.jpamappingedu.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", referencedColumnName = "id")
    @JsonBackReference
    private Team parentTeam;

    @OneToMany
    @JoinColumn(name = "parentId")
    @JsonManagedReference
    private List<Team> teams;

    //private Long parentId;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonManagedReference
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
        //this.members = new ArrayList<>();
    }
}
