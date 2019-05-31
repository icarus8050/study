package com.example.jpamappingedu.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PhoneNumber {

    private String areaCode;
    private String localNumber;

    @ManyToOne
    private PhoneServiceProvider provider;
}
