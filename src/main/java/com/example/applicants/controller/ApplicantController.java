package com.example.applicants.controller;

import com.example.applicants.model.Applicant;
import com.example.applicants.service.ApplicantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicantController {

    private final ApplicantService service;

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    @GetMapping("/applicants")
    List<Applicant> getAllApplicants() {
        return service.getAllApplicants();
    }


}
