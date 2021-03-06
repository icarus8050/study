package com.example.stackoverflow_with_lombok.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    private String street;

    @Embedded
    private Zipcode zipcode;
}
