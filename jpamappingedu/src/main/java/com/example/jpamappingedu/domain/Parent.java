package com.example.jpamappingedu.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Parent {

    @Id
    @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
