package com.example.applicants.service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestVehicleFactors {
    //Testing vehicle type factors
    @Test
    void testVehicleTypeFactorWhenCabriolet_ShouldReturn1point3() {

        double vehicleFactor = CalculateQuote.vehicleTypeFactor("Cabriolet");
        assertEquals(1.3, vehicleFactor);
    }

    @Test
    void testVehicleTypeFactorWhenCoupe_ShouldReturn1point4() {

        double vehicleFactor = CalculateQuote.vehicleTypeFactor("Coupe");
        assertEquals(1.4, vehicleFactor);
    }

    @Test
    void testVehicleTypeFactorWhenEstate_ShouldReturn1point5() {

        double vehicleFactor = CalculateQuote.vehicleTypeFactor("Estate");
        assertEquals(1.5, vehicleFactor);
    }

    @Test
    void testVehicleTypeFactorWhenHatchback_ShouldReturn1point6() {

        double vehicleFactor = CalculateQuote.vehicleTypeFactor("Hatchback");
        assertEquals(1.6, vehicleFactor);
    }

    @Test
    void testVehicleTypeFactorWhenOther_ShouldReturn1point7() {

        double vehicleFactor = CalculateQuote.vehicleTypeFactor("Other");
        assertEquals(1.7, vehicleFactor);
    }

    //Testing Engine size factors
    @Test
    void testEngineSizeFactorWhen1000_ShouldReturn1point0() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("1000");
        assertEquals(1.0, vehicleFactor);
    }

    @Test
    void testEngineSizeFactorWhen1600_ShouldReturn1point6() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("1600");
        assertEquals(1.6, vehicleFactor);
    }

    @Test
    void testEngineSizeFactorWhen2000_ShouldReturn2point0() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("2000");
        assertEquals(2.0, vehicleFactor);
    }

    @Test
    void testEngineSizeFactorWhen2500_ShouldReturn2point5() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("2500");
        assertEquals(2.5, vehicleFactor);
    }

    @Test
    void testEngineSizeFactorWhen3000_ShouldReturn3point0() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("3000");
        assertEquals(3.0, vehicleFactor);
    }

    @Test
    void testEngineSizeFactorWhenOther_ShouldReturn3point5() {

        double vehicleFactor = CalculateQuote.engineSizeFactor("Other");
        assertEquals(3.5, vehicleFactor);
    }

    //Testing vehicle value factor
    @Test
    void testVehicleValueFactorWhenLessThan5000_ShouldReturn1point0() {

        double vehicleFactor = CalculateQuote.vehicleValueFactor("1000");
        assertEquals(1.0, vehicleFactor);
    }

    @Test
    void testVehicleValueFactorWhenMoreThan5000_ShouldReturn1point2() {

        double vehicleFactor = CalculateQuote.vehicleValueFactor("5001");
        assertEquals(1.2, vehicleFactor);
    }

    //Testing additional drivers factor
    @Test
    void testAdditionalDriversFactorWhenLessThan2Drivers_ShouldReturn1point1() {

        double vehicleFactor = CalculateQuote.addDriversFactor("0");
        assertEquals(1.1, vehicleFactor);
    }

    @Test
    void testAdditionalDriversFactorWhenMoreThan2Drivers_ShouldReturn1point2() {

        double vehicleFactor = CalculateQuote.addDriversFactor("3");
        assertEquals(1.2, vehicleFactor);
    }

    //Testing commercial purpose factor
    @Test
    void testCommercialPurposeFactorWhenResponseYes_ShouldReturn1point1() {

        double vehicleFactor = CalculateQuote.commUseFactor("Yes");
        assertEquals(1.1, vehicleFactor);
    }

    @Test
    void testCommercialPurposeFactorWhenResponseNo_ShouldReturn1point0() {

        double vehicleFactor = CalculateQuote.commUseFactor("No");
        assertEquals(1.0, vehicleFactor);
    }

    //Testing registered outside state factor
    @Test
    void testRegOutsideStateFactorWhenResponseYes_ShouldReturn1point1() {

        double vehicleFactor = CalculateQuote.outsideStateFactor("Yes");
        assertEquals(1.1, vehicleFactor);
    }

    @Test
    void testRegOutsideStateFactorWhenResponseNo_ShouldReturn1point0() {

        double vehicleFactor = CalculateQuote.outsideStateFactor("No");
        assertEquals(1.0, vehicleFactor);
    }





}
