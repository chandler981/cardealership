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

import org.dealership.driverClass;
import org.dealership.Entities.Employee;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateEmployeeInfoController {

    driverClass driver = new driverClass();

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
        Employee employee = new Employee();
        employee.updateEMployeeInformationHelper(EmpAddressChange.getText(), EmpBankNumChange.getText(), EmpID.getText(), EmpPhoneNumChange.getText(), EmpSSNChange.getText());
    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
