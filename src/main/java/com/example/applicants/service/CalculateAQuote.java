package com.example.applicants.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CalculateAQuote {

    public static double vehicleTypeFactor(String vehicleType) {
        switch (vehicleType) {
            case "Cabriolet":
                return 1.3;
            case "Coupe":
                return 1.4;
            case "Estate":
                return 1.5;
            case "Hatchback":
                return 1.6;
            case "Other":
                return 1.7;
            default:
                return 0.0;
        }//Switch (Could Replace with If Else)
    }

    public static double engineSizeFactor(String engineSize) {

        if (engineSize.equalsIgnoreCase("1000")) {
            return 1.0;
        } else if (engineSize.equalsIgnoreCase("1600")) {
            return 1.6;
        } else if (engineSize.equalsIgnoreCase("2000")) {
            return 2.0;
        } else if (engineSize.equalsIgnoreCase("2500")) {
            return 2.5;
        } else if (engineSize.equalsIgnoreCase("3000")) {
            return 3.0;
        } else {
            return 3.5;
        }
    }

    public static double vehicleValueFactor(String currentValue) {
        int vehicleValueNo = Integer.parseInt(currentValue);

        if (vehicleValueNo <= 5000) {
            return 1.0;
        } else {
            return 1.2;
        }
    }

    public static double addDriversFactor(String additionalDrivers) {
        int addDriversNo = Integer.parseInt(additionalDrivers);

        if (addDriversNo < 2) {
            return 1.1;
        } else {
            return 1.2;
        }
    }

    public static double commUseFactor(String commercialPurposes){
        if (commercialPurposes.equalsIgnoreCase("Yes") ) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

    public static double outsideStateFactor(String registeredState) {
        if (registeredState.equalsIgnoreCase("Yes")) {
            return 1.1;
        } else {
            return 1.0;
        }
    }

    public static double calculateFinalQuote(double vehicleTypeFactor, double engineSizeFactor, double additionalDriversFactor, double commercialUseFactor,
                                             double outsideStateFactor, double vehicleValueFactor) {
        DecimalFormat df = new DecimalFormat("00.00");
        double value = 100 * vehicleTypeFactor * engineSizeFactor * additionalDriversFactor * commercialUseFactor * outsideStateFactor * vehicleValueFactor;
        return Double.parseDouble(df.format(value));
    }
}