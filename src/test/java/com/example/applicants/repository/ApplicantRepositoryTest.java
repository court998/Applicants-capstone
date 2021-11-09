package com.example.applicants.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // without this will throw exception error

class ApplicantRepositoryTest {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Test
    void shouldFindJohn_usingCustomRepoMethodAndReturn1() {
        assertEquals(1, applicantRepository.findByFirstNameAndLastName("John","Healy").size());
    }

    @Test
    void shouldFindSam_usingCustomRepoMethodAndReturn1(){
        assertEquals(1, applicantRepository.findByFirstNameAndLastName("Sam","Watson").size());
    }

    @Test
    void shouldFind0_usingCustomRepoMethod_whenApplicantNotAdded(){
        assertEquals(0, applicantRepository.findByFirstNameAndLastName("James","Bond").size());
    }


}