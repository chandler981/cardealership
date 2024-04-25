/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
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

import org.dealership.mainClass;

import javafx.event.ActionEvent;
 import javafx.fxml.FXML;
 
 public class EmployeeOptionsController {

    mainClass driver = new mainClass();
 
    @FXML
    void BuyVehicle(ActionEvent event) throws IOException {
        driver.changeScene("SearchVehicleInformationPanel.fxml");
    }

    @FXML
    void SearchVehicleInfo(ActionEvent event) throws IOException {
        driver.changeScene("SearchVehicleInformationPanel.fxml");
    }

    @FXML
    void WeeklyDiscounts(ActionEvent event) throws IOException {
        driver.changeScene("WeeklyDealsPanel.fxml");
    }

    @FXML
    void SignOut(ActionEvent event) throws IOException {
        driver.changeScene("LoginScreenPanel.fxml");
    }
     
 }
