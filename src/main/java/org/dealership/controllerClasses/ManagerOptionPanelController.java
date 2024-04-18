/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 2 / 6 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for handling what screen the manager
 * is redirected to based on the button they press.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.mainClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ManagerOptionPanelController {

    mainClass driver = new mainClass();

     @FXML
    void CalculateCommissionPage(ActionEvent event) throws IOException {
        driver.changeScene("CalculateComissionPage.fxml");
    }

    @FXML
    void GoToRecordInformationPage(ActionEvent event) throws IOException {
        driver.changeScene("RecordNewVehicleInformation.fxml");
    }

    @FXML
    void OrderVehiclePage(ActionEvent event) throws IOException {
        driver.changeScene("OrderVehiclePage.fxml");
    }

    @FXML
    void UpdateEmpInfoPage(ActionEvent event) throws IOException {
        driver.changeScene("UpdateEmployeeInfoPanel.fxml");
    }

    @FXML
    void WeeklyDealsPage(ActionEvent event) throws IOException {
        driver.changeScene("WeeklyDealsPanel.fxml");
    }
    
    @FXML
    void SignOutButton(ActionEvent event) throws IOException {
        driver.changeScene("LoginScreenPanel.fxml");
    }
    
}
