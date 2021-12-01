package com.example.applicants.service;

import com.example.applicants.model.Applicant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestQuoteAmount {
    @Test
    public void testCalculateAQuote_WhenOtherEngineSizeOtherNoAddDrivers0UsedOutsideOfStateYesAndComPurposeNoValue50000_ShouldReturn863Point94() {
        Applicant applicant = new Applicant(null, "Ms", "Angelina", "Jolie", "098372829",
                "7 Hollywood Hills", "Block 2", "Los Angeles", "12345-6785", "Other",
                "Other", "0", "No", "Yes", "2021-07-01", "50000",
                0.00);

        double vehicleTypeFactorResult = CalculateQuote.vehicleTypeFactor(applicant.getVehicleType());
        double engineSizeFactorResult = CalculateQuote.engineSizeFactor(applicant.getEngineSize());
        double vehicleValueFactorResult = CalculateQuote.vehicleValueFactor(applicant.getCurrentValue());
        double addDriversFactorResult = CalculateQuote.addDriversFactor(applicant.getAdditionalDrivers());
        double commUseFactorResult = CalculateQuote.commUseFactor(applicant.getCommercialPurposes());
        double outsideStateFactorResult = CalculateQuote.outsideStateFactor(applicant.getRegisteredState());

        double quoteResult = CalculateQuote.calculateFinalQuote(vehicleTypeFactorResult, engineSizeFactorResult, vehicleValueFactorResult,
                addDriversFactorResult, commUseFactorResult, outsideStateFactorResult);

        assertEquals(863.94, quoteResult);
    }//testCalculateAQuote_WhenEngineSize16003DriversUsedCommOutsideOfStateEtc_ShouldReturnCorrectQuoteValue

    @Test
    void testCalculateAQuote_WhenCoupeEngineSize2000AddDrivers3UsedOutsideOfStateNoAndComPurposeYesValue3000_ShouldReturn369Point6(){

        double vehicleType = CalculateQuote.vehicleTypeFactor("Coupe");
        double engineSize = CalculateQuote.engineSizeFactor("2000");
        double additionalDrivers = CalculateQuote.addDriversFactor("3");
        double commercialUse = CalculateQuote.commUseFactor("Yes");
        double usedOutsideState = CalculateQuote.outsideStateFactor("No");
        double marketValue = CalculateQuote.vehicleValueFactor("3000");

        double quoteResult = CalculateQuote.calculateFinalQuote(vehicleType, engineSize, additionalDrivers, commercialUse, usedOutsideState, marketValue);
        assertEquals(369.6, quoteResult);
    }// shorter test method


    @Test
    void testCalculateAQuote_WhenHatchbackEngineSize1000AddDrivers2UsedOutsideOfStateYesAndComPurposeNoValue8000_ShouldReturn253Point44(){

        double vehicleType = CalculateQuote.vehicleTypeFactor("Hatchback");
        double engineSize = CalculateQuote.engineSizeFactor("1000");
        double additionalDrivers = CalculateQuote.addDriversFactor("2");
        double commercialUse = CalculateQuote.commUseFactor("No");
        double usedOutsideState = CalculateQuote.outsideStateFactor("Yes");
        double marketValue = CalculateQuote.vehicleValueFactor("8000");

        double quoteResult = CalculateQuote.calculateFinalQuote(vehicleType, engineSize, additionalDrivers, commercialUse, usedOutsideState, marketValue);
        assertEquals(253.44, quoteResult);
    }// shorter test method

    @Test
    void testCalculateAQuote_WhenCabrioletEngineSize2000AddDrivers1UsedOutsideOfStateYesAndComPurposeYesValue25000_ShouldReturn415Point27(){

        double vehicleType = CalculateQuote.vehicleTypeFactor("Cabriolet");
        double engineSize = CalculateQuote.engineSizeFactor("2000");
        double additionalDrivers = CalculateQuote.addDriversFactor("1");
        double commercialUse = CalculateQuote.commUseFactor("Yes");
        double usedOutsideState = CalculateQuote.outsideStateFactor("Yes");
        double marketValue = CalculateQuote.vehicleValueFactor("25000");

        double quoteResult = CalculateQuote.calculateFinalQuote(vehicleType, engineSize, additionalDrivers, commercialUse, usedOutsideState, marketValue);
        assertEquals(415.27,quoteResult);
    }// shorter test method

    @Test
    void testCalculateAQuote_WhenEstateEngineSize1600AddDrivers0UsedOutsideOfStateNoAndComPurposeNoValue1000_ShouldReturn264(){

        double vehicleType = CalculateQuote.vehicleTypeFactor("Estate");
        double engineSize = CalculateQuote.engineSizeFactor("1600");
        double additionalDrivers = CalculateQuote.addDriversFactor("0");
        double commercialUse = CalculateQuote.commUseFactor("No");
        double usedOutsideState = CalculateQuote.outsideStateFactor("No");
        double marketValue = CalculateQuote.vehicleValueFactor("1000");

        double quoteResult = CalculateQuote.calculateFinalQuote(vehicleType, engineSize, additionalDrivers, commercialUse, usedOutsideState, marketValue);
        assertEquals(264, quoteResult);
    }// shorter test method

}
