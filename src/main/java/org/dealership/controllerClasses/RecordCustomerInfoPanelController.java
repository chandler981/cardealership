/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 2 / 13 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for allowing the employee
 * to enter the customers information to be stored
 * in the database to be used at time of purchase
 * or just for records.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecordCustomerInfoPanelController {

    @FXML
    private TextField CustomerCreditScore;

    @FXML
    private TextField CustomerDLN;

    @FXML
    private TextField CustomerDOB;

    @FXML
    private TextField CustomerFirstAndLast;

    @FXML
    private TextField CustomerInsuranceNum;

    @FXML
    private TextField CustomerPhoneNum;

    @FXML
    private TextField CustomerSSN;

    @FXML
    private TextField CustomerState;

    @FXML
    private TextField CustomerZipCOde;

    @FXML
    void EnterCustomerInfo(ActionEvent event) {

    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driverClass driver = new driverClass();
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    
}
