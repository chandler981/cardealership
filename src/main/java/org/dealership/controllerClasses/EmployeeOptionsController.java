/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling what screen is accessed
 * by the employee and for redirecting the employee
 * to a selected scene based on the button pressed.
 *  
 * % java driverClass
 */

 package org.dealership.controllerClasses;

 import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 
 public class EmployeeOptionsController {

    driverClass driver = new driverClass();
 
    @FXML
    void BuyVehicle(ActionEvent event) throws IOException {
        driver.changeScene("CustomerBuyingVehiclePanel.fxml");
    }

    @FXML
    void CreateInvoice(ActionEvent event) throws IOException {
        driver.changeScene("CreateInvoicePanel.fxml");
    }

    @FXML
    void OrderVehicle(ActionEvent event) throws IOException {
        driver.changeScene("OrderVehiclePage.fxml");
    }

    @FXML
    void RecCustomerInfo(ActionEvent event) throws IOException {
        driver.changeScene("RecordCustomerInfoPanel.fxml");
    }

    @FXML
    void SearchVehicleInfo(ActionEvent event) throws IOException {
        driver.changeScene("SearchVehicleInformationPanel.fxml");
    }

    @FXML
    void SignOut(ActionEvent event) throws IOException {
        driver.changeScene("LoginScreenPanel.fxml");
    }

    @FXML
    void TradeInVehicle(ActionEvent event) throws IOException {
        driver.changeScene("VehicleTradeInInformationPanel.fxml");
    }

    @FXML
    void WeeklyDiscounts(ActionEvent event) throws IOException {
        driver.changeScene("WeeklyDealsPanel.fxml");
    }
     
 }
