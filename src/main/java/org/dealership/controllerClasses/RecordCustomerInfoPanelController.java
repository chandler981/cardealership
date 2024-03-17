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
import org.dealership.backend.CustomerInformationDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RecordCustomerInfoPanelController {

    driverClass driver = new driverClass();

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
    void EnterCustomerInfo(ActionEvent event) throws IOException {
        //getting input from stage into usable varibles
        String SSN = CustomerSSN.getText();
        String driverLicense = CustomerDLN.getText();
        String dateOfBirth = CustomerDOB.getText();
        String phoneNumber = CustomerPhoneNum.getText();
        String name = CustomerFirstAndLast.getText();
        String customerAddress = CustomerState.getText() + " " + CustomerZipCOde.getText();
        Float downPayment = (float) 0.00;
        String creditScore = CustomerCreditScore.getText();
        String insuranceNo = CustomerInsuranceNum.getText();

        // split name to first and last, plus a trim incase of extra space as first
        String[] names=name.trim().split("\\s+");
        String firstName = names[0];
        String lastName = names[1]; 

        // sending to database
        CustomerInformationDAO customer = new CustomerInformationDAO();
        customer.addNewCustomerInfoHelper(SSN,  driverLicense,  dateOfBirth, phoneNumber,  firstName,  lastName,  customerAddress, downPayment, creditScore, insuranceNo);
        driver.changeScene("VehicleTradeInInformationPanel.fxml");
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driverClass driver = new driverClass();
        driver.changeScene("EmployeeOptionsPanel.fxml");
        }

    //this method and button is for testing purposes
    @FXML
    void TradeInVehicle(ActionEvent event) throws IOException {
        driver.changeScene("VehicleTradeInInformationPanel.fxml");
    }
}
