package com.example.applicants.model;

import javax.persistence.*;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;
    @Column
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipcode;
    private String vehicleType;
    private String engineSize;
    private String additionalDrivers;
    private String commercialPurposes;
    private String registeredState;
    private String vehicleRegistered;
    private String currentValue;
    private double quoteAmount;

    public Applicant(Long id, String prefix, String firstName, String lastName, String telephoneNumber, String addressLine1, String addressLine2, String city, String zipcode, String vehicleType, String engineSize, String additionalDrivers, String commercialPurposes, String registeredState, String vehicleRegistered, String currentValue, double quoteAmount) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipcode = zipcode;
        this.vehicleType = vehicleType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialPurposes = commercialPurposes;
        this.registeredState = registeredState;
        this.vehicleRegistered = vehicleRegistered;
        this.currentValue = currentValue;
        this.quoteAmount = quoteAmount;
    }


    public Applicant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipCode(String zipCode) {
        this.zipcode = zipcode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(String additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public String getCommercialPurposes() {
        return commercialPurposes;
    }

    public void setCommercialPurposes(String commercialPurposes) {
        this.commercialPurposes = commercialPurposes;
    }

    public String getRegisteredState() {
        return registeredState;
    }

    public void setRegisteredState(String registeredState) {
        this.registeredState = registeredState;
    }

    public String getVehicleRegistered() {
        return vehicleRegistered;
    }

    public void setVehicleRegistered(String vehicleRegistered) {
        this.vehicleRegistered = vehicleRegistered;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public double getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(double quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;


    }
}