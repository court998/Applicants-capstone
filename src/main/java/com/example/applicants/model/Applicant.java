package com.example.applicants.model;

import javax.persistence.*;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;
    @Column
    private String firstname;
    private String lastname;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postcode;
    private String vehicleType;
    private String engineSize;
    private String additionalDrivers;
    private String commercialPurposes;
    private String usedOutsideState;
    private String currentValue;
    private String dateRegistered;
    private String comments;


    public Applicant() {
    }

    public Applicant(Long id, String prefix, String firstname, String lastname, String phone, String addressLine1, String addressLine2, String city, String postcode, String vehicleType, String engineSize, String additionalDrivers, String commercialPurposes, String usedOutsideState, String currentValue, String dateRegistered, String comments) {
        this.id = id;
        this.prefix = prefix;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.postcode = postcode;
        this.vehicleType = vehicleType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialPurposes = commercialPurposes;
        this.usedOutsideState = usedOutsideState;
        this.currentValue = currentValue;
        this.dateRegistered = dateRegistered;
        this.comments = comments;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getUsedOutsideState() {
        return usedOutsideState;
    }

    public void setUsedOutsideState(String usedOutsideState) {
        this.usedOutsideState = usedOutsideState;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
