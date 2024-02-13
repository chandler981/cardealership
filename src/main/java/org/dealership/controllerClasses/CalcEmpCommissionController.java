/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for updating the employee's
 * commissions based on how many sales they make
 * over a specified time slot.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;
import org.dealership.Entities.employee;
import org.dealership.backend.employeeInformationSQL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalcEmpCommissionController {
    
    driverClass driver = new driverClass();
    employee employee = new employee();
    employeeInformationSQL empSQL = new employeeInformationSQL();

    @FXML
    private TextField comissionAmnt;

    @FXML
    private TextField employeeIDForComission;

    @FXML
    void CalculateComissionAmount(ActionEvent event) throws IOException{
        Double newCommVal = Double.parseDouble(comissionAmnt.getText());
        System.out.println("entered ammount is " + newCommVal);
        empSQL.inputNewCommAmntHelper(employeeIDForComission.getText(), comissionAmnt.getText());
    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
