package com.example.stackoverflow_with_lombok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(exclude = {"members"})
@EqualsAndHashCode(of = "id", callSuper = false)
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

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public void addAllMembers(List<Member> members) {
        this.members.addAll(members);

        for (Member m : members) {
            m.setTeam(this);
        }
    }
}
