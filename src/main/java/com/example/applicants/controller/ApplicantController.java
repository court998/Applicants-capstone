package com.example.applicants.controller;

import com.example.applicants.model.Applicant;
import com.example.applicants.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class ApplicantController {

    private final ApplicantService service;
    public static final String ID_NOT_FOUND_ERROR_MSG = "Applicant Not Found, id: ";

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/applicants")
    List<Applicant> getAllApplicants() {
        return service.getAllApplicants();
    }//GET

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/applicants")
    Applicant save(@RequestBody Applicant applicant) {
        return service.save(applicant);
    }//POST

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/applicants")
    void deleteRecord(@RequestParam Long id) {
        try {
            Applicant applicantToDelete = service.findApplicant(id);
            service.delete(applicantToDelete.getId());
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, exception);
        }
    }//DELETE

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/applicants/id")
    Optional<Applicant> getSingleApplicant(@RequestParam Long id) {
        return service.getSingleApplicant(id);
    }//GET A Single Record

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/applicants")
    void updateAPhoneNumber(@RequestParam Long id, @RequestParam String telephoneNumber) {
        service.updateNumber(id, telephoneNumber);
    }//UPDATE telephoneNumber

}
