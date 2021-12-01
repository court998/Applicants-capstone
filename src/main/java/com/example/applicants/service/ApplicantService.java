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
        double vehicleTypeFactorResult = CalculateQuote.vehicleTypeFactor(applicant.getVehicleType());
        double engineSizeFactorResult = CalculateQuote.engineSizeFactor(applicant.getEngineSize());
        double vehicleValueFactorResult = CalculateQuote.vehicleValueFactor(applicant.getCurrentValue());
        double addDriversFactorResult = CalculateQuote.addDriversFactor(applicant.getAdditionalDrivers());
        double commUseFactorResult = CalculateQuote.commUseFactor(applicant.getCommercialPurposes());
        double outsideStateFactorResult = CalculateQuote.outsideStateFactor(applicant.getRegisteredState());
        double finalQuoteAmount = CalculateQuote.calculateFinalQuote(vehicleTypeFactorResult, engineSizeFactorResult, vehicleValueFactorResult,
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