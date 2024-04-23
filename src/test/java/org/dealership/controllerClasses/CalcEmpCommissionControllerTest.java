package org.dealership.controllerClasses;

import org.dealership.backend.InputValidation;
import org.junit.*;

public class CalcEmpCommissionControllerTest {  

    //testing with correct inputs
    @Test
    public void CalcEmpCOmmissionControllerTestOne(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(true, input.IDValidaiton("1001"));
        Assert.assertEquals(true, input.commissionValidation("34.5"));

    }

    //testing with incorrect inputs
    @Test
    public void CalcEmpCOmmissionControllerTestTwo(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(false, input.IDValidaiton("1B01"));
        Assert.assertEquals(false, input.commissionValidation("34.5666"));
        
    }

    
}
