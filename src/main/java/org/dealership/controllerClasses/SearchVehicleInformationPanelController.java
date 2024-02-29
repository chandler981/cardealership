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
    driverClass driver = new driverClass();

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
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void SearchVehicleInfo(ActionEvent event) throws IOException {
        /*create conditional once search page is complete so that if a vehicle
         * is searched it will redirect to the order vehicle page, until then this 
         * will only take you to the vehicle information page
         */
        

        driver.changeScene("SearchVehicleInfoResultPanel.fxml");
    }

    
}
