package com.example.stackoverflow_with_lombok.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneServiceProvider {

    @Id
    private String name;
}
