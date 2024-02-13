/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 2 / 13 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file is for allowing the employee
 * to enter the information the customer gives
 * them and then to search the database and give 
 * any results for what the customer wanted.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;

import org.dealership.driverClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchVehicleInformationPanelController {

    @FXML
    private TextField VehicleColorSearch;

    @FXML
    private TextField VehicleMakeSearch;

    @FXML
    private TextField VehicleMileageSearch;

    @FXML
    private TextField VehicleModelSearch;

    @FXML
    private TextField VehicleTypeSearch;

    @FXML
    private TextField VehicleYearSearch;

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driverClass driver = new driverClass();
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void SearchVehicleInfo(ActionEvent event) {

    }

    
}
