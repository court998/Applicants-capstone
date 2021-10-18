package com.example.applicants.service;

import com.example.applicants.model.Applicant;
import com.example.applicants.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepository repository;

    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }

    public List<Applicant> getAllApplicants() {
        return repository.findAll();
    }

    public Applicant postApplicant(Applicant applicant) {
        return repository.save(applicant);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Applicant> getSingleApplicant(Long id) {
        return repository.findById(id);
    }

    public Optional<Applicant> updatePhone(Long id, String phone) {

        return repository.findById(id)
                .map(recordForUpdating -> {
                    recordForUpdating.setPhone(phone);
                    return repository.save(recordForUpdating);
                });
    }
}
