package com.example.stackoverflow_with_lombok.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;


    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }
}
