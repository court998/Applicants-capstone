package com.example.applicants.controller;

import com.example.applicants.service.ApplicantService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

    private final ApplicantService service;

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }


}
