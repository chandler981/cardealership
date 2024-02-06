/*
 * Author:       
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

package org.dealership;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalcEmpCommissionController {
    
    driverClass driver = new driverClass();

    @FXML
    private TextField comissionAmnt;

    @FXML
    private TextField employeeIDForComission;

    @FXML
    void CalculateComissionAmount(ActionEvent event) {

    }

    @FXML
    void goBackButton(ActionEvent event) throws IOException {
        driver.changeScene("ManagerOptionPanel.fxml");
    }

    
}
