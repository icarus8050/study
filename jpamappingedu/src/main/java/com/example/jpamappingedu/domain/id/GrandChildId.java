package com.example.jpamappingedu.domain.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GrandChildId implements Serializable {

    private ChildId childId;

    @Column(name = "GRANDCHILD_ID")
    private String id;
}
