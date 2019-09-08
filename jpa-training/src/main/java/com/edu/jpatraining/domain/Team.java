package com.edu.jpatraining.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Team implements Serializable {

    private static final long serialVersionUID = -4407916560571607139L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Version
    private Integer version;

    @OneToMany(mappedBy = "team")
    @JsonManagedReference
    private List<Member> members;
}
