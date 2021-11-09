package com.example.applicants.service;

import com.example.applicants.model.Applicant;
import com.example.applicants.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepository repository;

    public ApplicantService(ApplicantRepository repository) {
        this.repository = repository;
    }

    public Applicant findApplicant(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("No Applicant with ID " + id));
    }

    public List<Applicant> getAllApplicants() {
        return repository.findAll();
    }//Get All Records

    public Applicant save(Applicant applicant) {
        //call to additional service class
        double vehicleTypeFactorResult = CalculateAQuote.vehicleTypeFactor(applicant.getVehicleType());
        double engineSizeFactorResult = CalculateAQuote.engineSizeFactor(applicant.getEngineSize());
        double vehicleValueFactorResult = CalculateAQuote.vehicleValueFactor(applicant.getCurrentValue());
        double addDriversFactorResult = CalculateAQuote.addDriversFactor(applicant.getAdditionalDrivers());
        double commUseFactorResult = CalculateAQuote.commUseFactor(applicant.getCommercialPurposes());
        double outsideStateFactorResult = CalculateAQuote.outsideStateFactor(applicant.getRegisteredState());
        double finalQuoteAmount = CalculateAQuote.calculateFinalQuote(vehicleTypeFactorResult, engineSizeFactorResult, vehicleValueFactorResult,
                addDriversFactorResult, commUseFactorResult, outsideStateFactorResult);
        System.out.println(finalQuoteAmount);
        applicant.setQuoteAmount(finalQuoteAmount);

        return repository.save(applicant);
    }//Save a New Record

    public void delete(Long id) {
        repository.deleteById(id);
    }//Delete a Record

    public Optional<Applicant> getSingleApplicant(Long id) {
        return repository.findById(id);
    }//get Single Applicant

    public Optional<Applicant> updateNumber(Long id, String telephoneNumber) {

        return repository.findById(id)
                .map(recordForUpdating -> {
                    recordForUpdating.setTelephoneNumber(telephoneNumber);
                    return repository.save(recordForUpdating);
                });
    }//Update Number
}