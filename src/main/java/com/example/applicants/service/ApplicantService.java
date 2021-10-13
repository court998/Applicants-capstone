package com.example.applicants.service;

import com.example.applicants.model.Applicant;
import com.example.applicants.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository repository;

    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }

    public List<Applicant> getAllApplicants() {
        List<Applicant> tempTest = new ArrayList<Applicant>();
        return tempTest;
    }
}
