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
import org.dealership.Entities.customer;
import org.dealership.backend.customerInformationSQL;
import org.dealership.backend.vehicleInformationSQL;

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
        //getting input from stage into usable varibles
       String SSN = CustomerSSN.getText();
       String driverLicense = CustomerDLN.getText();
       String dateOfBirth = CustomerDOB.getText();
       String phoneNumber = CustomerPhoneNum.getText();
       String name = CustomerFirstAndLast.getText();
       String customerAddress = CustomerState.getText() + " " + CustomerZipCOde.getText();
       String creditScore = CustomerCreditScore.getText();
       String insuranceNo = CustomerInsuranceNum.getText();

       // split name to first and last, plus a trim incase of extra space as first
       String[] names=name.trim().split("\\s+");
       String firstName = names[0];
       String lastName = names[1]; 

       //method for creating Customer ID here
        String customerID =customer.createID();


    // sending to database
    customerInformationSQL customer = new customerInformationSQL();
    customer.addNewCustomerInfoHelper(customerID, SSN,  driverLicense,  dateOfBirth, phoneNumber,  firstName,  lastName,  customerAddress,  creditScore,  insuranceNo);
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driverClass driver = new driverClass();
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    
}
