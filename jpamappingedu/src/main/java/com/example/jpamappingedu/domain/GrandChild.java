package com.example.jpamappingedu.domain;

import com.example.jpamappingedu.domain.id.GrandChildId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class GrandChild {

    @EmbeddedId
    private GrandChildId id;

    @MapsId("childId")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "PARENT_ID"),
            @JoinColumn(name = "CHILD_ID")
    })
    private Child child;

    private String name;
}
