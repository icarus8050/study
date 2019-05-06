package com.example.jpamappingedu.domain.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChildId implements Serializable {

    private String parentId;

    @Column(name = "CHILD_ID")
    private String id;
}
