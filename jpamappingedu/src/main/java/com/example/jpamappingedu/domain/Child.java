package com.example.jpamappingedu.domain;

import com.example.jpamappingedu.domain.id.ChildId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Child {

    @EmbeddedId
    private ChildId id;
    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    public Parent parent;

    private String name;
}
