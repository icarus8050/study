package com.example.jpaedu.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Member {
    @Id
    private Long id;
    private String name;
    private Integer age;
}
