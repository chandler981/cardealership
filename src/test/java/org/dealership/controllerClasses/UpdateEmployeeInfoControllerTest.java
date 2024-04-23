package org.dealership.controllerClasses;

import org.dealership.backend.InputValidation;
import org.junit.*;

public class UpdateEmployeeInfoControllerTest {
    

    @Test
    public void UpdateEmployeeInfoEnterTestOne(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(true, input.AddressValidation("1234 Mockingbird Lane"));
        Assert.assertEquals(true, input.BankNumValidation("1234567890"));
        Assert.assertEquals(true, input.PhoneNumValidation("(217) 555-1234"));
        Assert.assertEquals(true, input.SSNValidation("123-45-6789"));
        

    }

    @Test
    public void UpdateEmployeeInfoEnterTestTwo(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(false, input.AddressValidation("23488292 `````"));
        Assert.assertEquals(true, input.BankNumValidation("1234567890"));
        Assert.assertEquals(true, input.PhoneNumValidation("(217) 555-1234"));
        Assert.assertEquals(true, input.SSNValidation("123-45-6789"));
        

    }

}
