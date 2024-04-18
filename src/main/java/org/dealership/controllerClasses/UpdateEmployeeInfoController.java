/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for updating a specified employees information 
 * based on what the manager inputs into the page.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.mainClass;
import org.dealership.Entities.Employee;
import org.dealership.backend.InputValidation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateEmployeeInfoController {

    mainClass driver = new mainClass();
    InputValidation validation = new InputValidation();
    boolean allValid = true;

    @FXML
    private TextField EmpAddressChange;

    @FXML
    private TextField EmpBankNumChange;

    @FXML
    private TextField EmpID;

    @FXML
    private TextField EmpPhoneNumChange;

    @FXML
    private TextField EmpSSNChange;

    @FXML
    void UpdateEmployeeInfoEnter(ActionEvent event) {
        //runs text inputs through the input validation class that has specific methods for types of input and return true or false based on if the input matches the created patterns

        if(!validation.AddressValidation(EmpAddressChange.getText())) {
            allValid = false;
            EmpAddressChange.clear(); // Clear the address field
        }

        if(!validation.SSNValidation(EmpSSNChange.getText())) {
            allValid = false;
            EmpSSNChange.clear(); // Clear the SSN field
        }

        if(!validation.PhoneNumValidation(EmpPhoneNumChange.getText())) {
            allValid = false;
            EmpPhoneNumChange.clear(); // Clear the phone number field
        }

        if(!validation.BankNumValidation(EmpBankNumChange.getText())) {
            allValid = false;
            EmpBankNumChange.clear(); // Clear the bank number field
        }

        if(allValid) {
            Employee employee = new Employee();
            employee.updateEMployeeInformationHelper(EmpAddressChange.getText(), EmpBankNumChange.getText(), EmpID.getText(), EmpPhoneNumChange.getText(), EmpSSNChange.getText());
        } else {
            // Optionally, display an error message to the user in the console
            System.out.println("Invalid input in one or more fields. Please correct and try again.");
        }

        // Employee employee = new Employee();
        // employee.updateEMployeeInformationHelper(EmpAddressChange.getText(), EmpBankNumChange.getText(), EmpID.getText(), EmpPhoneNumChange.getText(), EmpSSNChange.getText());


    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }



    
}
