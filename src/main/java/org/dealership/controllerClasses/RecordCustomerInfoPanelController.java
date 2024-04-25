/*
* Author:       Chandler Ward
* Written:      2 / 13 / 2024
* Last Updated: 4 / 25 / 2024
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

import org.dealership.mainClass;
import org.dealership.Entities.Customer;
import org.dealership.backend.CustomerInformationDAO;
import org.dealership.backend.InputValidation;

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
    
    mainClass driver = new mainClass();
    InputValidation validation = new InputValidation();
    boolean allValid = true;

    @FXML
    void EnterCustomerInfo(ActionEvent event) throws IOException {
        if(!validation.SSNValidation(CustomerSSN.getText())){
            allValid = false;
            CustomerSSN.clear();
        }
        if(!validation.PhoneNumValidation(CustomerPhoneNum.getText())){
            allValid = false;
            CustomerPhoneNum.clear();
        }
        if(!validation.NameValidation(CustomerFirstAndLast.getText())){
            allValid = false;
            CustomerFirstAndLast.clear();
        }
        if(!validation.CreditScoreValidation(CustomerCreditScore.getText())){
            allValid = false;
            CustomerCreditScore.clear();
        }
        if(!validation.BirthDayValidation(CustomerDOB.getText())){
            allValid = false;
            CustomerDOB.clear();
        }
        if(!validation.ZipCodeValidation(CustomerZipCOde.getText())){
            allValid = false;
            CustomerZipCOde.clear();
        }
        if(!validation.StateAbrvValidation(CustomerState.getText())){
            allValid = false;
            CustomerState.clear();
        }
        if(!validation.LicenseNumberValidation(CustomerDLN.getText())){
            allValid = false;
            CustomerDLN.clear();
        }
        if(!validation.InsuranceNumberValidation(CustomerInsuranceNum.getText())){
            allValid = false;
            CustomerInsuranceNum.clear();
        }

        if(allValid){
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
            Customer customerSSN = new Customer(SSN);
            customer.addNewCustomerInfoHelper(SSN,  driverLicense,  dateOfBirth, phoneNumber,  firstName,  lastName,  customerAddress, downPayment, creditScore, insuranceNo);
            driver.changeScene("VehicleTradeInInformationPanel.fxml");
        }
        else{
            System.out.println("Invalid input in one or more fields.");
        }
    }

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        mainClass driver = new mainClass();
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    //this method and button is for testing purposes
    @FXML
    void TradeInVehicle(ActionEvent event) throws IOException {
        Customer customerSSN = new Customer("987-65-4321");
        driver.changeScene("VehicleTradeInInformationPanel.fxml");
    }
}
