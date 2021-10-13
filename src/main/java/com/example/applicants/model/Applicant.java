package com.example.applicants.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String zipCode;
    private String vehicleType;
    private String engineSize;
    private String additionalDrivers;
    private String commercialPurpose;
    private String usedOutsideOfState;
    private String currentValue;
    private String regDate;
    private String addComments;


    public Applicant() {
    }

    public Applicant(Long id, String prefix, String firstName, String lastName, String phoneNumber, String addressLineOne, String addressLineTwo, String city, String zipCode, String vehicleType, String engineSize, String additionalDrivers, String commercialPurpose, String usedOutsideOfState, String currentValue, String regDate, String addComments) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.city = city;
        this.zipCode = zipCode;
        this.vehicleType = vehicleType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialPurpose = commercialPurpose;
        this.usedOutsideOfState = usedOutsideOfState;
        this.currentValue = currentValue;
        this.regDate = regDate;
        this.addComments = addComments;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getCommercialPurpose() {
        return commercialPurpose;
    }

    public void setCommercialPurpose(String commercialPurpose) {
        this.commercialPurpose = commercialPurpose;
    }

    public String getUsedOutsideOfState() {
        return usedOutsideOfState;
    }

    public void setUsedOutsideOfState(String usedOutsideOfState) {
        this.usedOutsideOfState = usedOutsideOfState;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getAddComments() {
        return addComments;
    }

    public void setAddComments(String addComments) {
        this.addComments = addComments;
    }
}
