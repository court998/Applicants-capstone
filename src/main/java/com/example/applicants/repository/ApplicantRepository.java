package com.example.applicants.repository;

import com.example.applicants.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    List<Applicant> findByFirstNameAndLastName(String firstName, String lastName);


}
