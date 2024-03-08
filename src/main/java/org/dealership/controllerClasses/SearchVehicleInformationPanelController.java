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
    VehicleInfoFromSearchController searchQuery = new VehicleInfoFromSearchController();

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

    public static String query;
    public static String dealQuery;

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

        String vehicleMake = VehicleMakeSearch.getText();
        String vehicleModel = VehicleModelSearch.getText();
        String vehicleType = VehicleTypeSearch.getText();
        String vehicleColor = VehicleColorSearch.getText();
        String vehicleYear = VehicleYearSearch.getText();
        int vehicleMileage = Integer.parseInt(VehicleMileageSearch.getText());

        query = "SELECT * from vehicle where vehicleMake = '" + vehicleMake + "' and vehicleModel = '" + vehicleModel + "' and vehicleType = '" + vehicleType + "' and vehicleColor = '"
            + vehicleColor + "' and vehicleYear = '" + vehicleYear + "' and vehicleMileage = '" + vehicleMileage + "'";

        dealQuery = "SELECT discount FROM deal WHERE vehicleType = '" + vehicleType + "'";


        driver.changeScene("SearchVehicleInfoResultPanel.fxml");
    }

    public String getQuery(){
        return (query);
    }

    public String getDealQuery(){
        return dealQuery;
    }

    
}
