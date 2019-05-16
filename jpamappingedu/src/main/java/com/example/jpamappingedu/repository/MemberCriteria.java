package com.example.jpamappingedu.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberCriteria {

    @PersistenceContext
    EntityManager entityManager;
}
