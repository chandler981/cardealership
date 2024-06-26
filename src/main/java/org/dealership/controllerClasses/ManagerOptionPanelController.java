/*
 * Author:       Chandler Ward
 * Written:      2 / 6 / 2024
 * Last Updated: 4 / 25 / 2024
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

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

 /*
  * This class simply has FXML methods that are 
  * attached to methods that handle going to or back 
  * to different pages
  */

public class ManagerOptionPanelController {

    driverClass driver = new driverClass();

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
    void SignOutButton(ActionEvent event) throws IOException {
        driver.changeScene("LoginScreenPanel.fxml");
    }
    
}
