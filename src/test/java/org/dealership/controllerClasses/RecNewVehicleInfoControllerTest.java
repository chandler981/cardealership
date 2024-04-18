package org.dealership.controllerClasses;
import java.io.IOException;

import org.dealership.backend.InputValidation;
import org.junit.*;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class RecNewVehicleInfoControllerTest {
    RecNewVehicleInfoController rec = new RecNewVehicleInfoController();

    /*
     * Test 1 where it should work correctly by using the input validation methods that
     * that the GUI also utilizes for input validation since testing the GUI directly 
     * cant be done.
     */
    @Test
    public void NewVehicleInputValidationTestOne(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(false, input.carColorValidation("234643"));
        Assert.assertEquals(true, input.carMakeValidation("Honda"));
        Assert.assertEquals(true, input.carModelValidation("Accord"));
        Assert.assertEquals(true, input.carTypeValidation("Sedan"));
        Assert.assertEquals(true, input.carMileageValidation("39,000"));
        Assert.assertEquals(true, input.carYearValidation("2003"));
        Assert.assertEquals(true, input.carConditionValidation("New"));
        Assert.assertEquals(true, input.carTransmissionValidation("Manual"));
        Assert.assertEquals(true, input.carVINValidation("3GNFL4E58CS616255"));

    }

    /*
     * Test 2 where it should work incorrectly by using the input validation methods that
     * that the GUI also utilizes for input validation since testing the GUI directly 
     * cant be done.
     */
    @Test
    public void NewVehicleInputValidationTestTwo(){
        InputValidation input = new InputValidation();
        Assert.assertEquals(true, input.carColorValidation("Blue"));
        Assert.assertEquals(true, input.carMakeValidation("Honda"));
        Assert.assertEquals(true, input.carModelValidation("Accord"));
        Assert.assertEquals(true, input.carTypeValidation("Sedan"));
        Assert.assertEquals(true, input.carMileageValidation("39,000"));
        Assert.assertEquals(true, input.carYearValidation("2003"));
        Assert.assertEquals(true, input.carConditionValidation("New"));
        Assert.assertEquals(true, input.carTransmissionValidation("Manual"));
        Assert.assertEquals(true, input.carVINValidation("3GNFL4E58CS616255"));

    }
}
