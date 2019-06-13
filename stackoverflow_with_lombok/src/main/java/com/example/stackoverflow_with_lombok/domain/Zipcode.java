package com.example.stackoverflow_with_lombok.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Zipcode {

    private String zip;
    private String plusFour;
}
