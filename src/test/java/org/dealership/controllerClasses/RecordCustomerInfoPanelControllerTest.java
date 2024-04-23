package org.dealership.controllerClasses;

import org.dealership.backend.InputValidation;
import org.junit.*;

public class RecordCustomerInfoPanelControllerTest {

    @Test
    public void RecordCustomerInfoPanelControllerTestOne(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(true, input.SSNValidation("123-45-6789"));
        Assert.assertEquals(true, input.PhoneNumValidation("(217) 555-1234"));
        Assert.assertEquals(true, input.NameValidation("John Doe"));
        Assert.assertEquals(true, input.CreditScoreValidation("750"));
        Assert.assertEquals(true, input.BirthDayValidation("1990-01-01"));
        Assert.assertEquals(true, input.ZipCodeValidation("12345"));
        Assert.assertEquals(true, input.StateAbrvValidation("CA"));
        Assert.assertEquals(true, input.LicenseNumberValidation("AB123456"));
        Assert.assertEquals(true, input.InsuranceNumberValidation("POL123456"));



    }

    @Test
    public void RecordCustomerInfoPanelControllerTestTwo(){
        InputValidation input = new InputValidation();

        Assert.assertEquals(false, input.SSNValidation("123-45-678")); //incorrect as is wrong length
        Assert.assertEquals(false, input.PhoneNumValidation("(217) 555-12")); //incorrect as is wrong length
        Assert.assertEquals(true, input.NameValidation("John Doe"));
        Assert.assertEquals(true, input.CreditScoreValidation("750"));
        Assert.assertEquals(true, input.BirthDayValidation("1990-01-01"));
        Assert.assertEquals(true, input.ZipCodeValidation("12345"));
        Assert.assertEquals(true, input.StateAbrvValidation("CA"));
        Assert.assertEquals(true, input.LicenseNumberValidation("AB123456"));
        Assert.assertEquals(true, input.InsuranceNumberValidation("POL123456"));

    }
    
}
