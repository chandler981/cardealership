/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 4 / 25 / 2024
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

import org.dealership.mainClass;
import org.dealership.Entities.Vehicle;
import org.dealership.backend.VehicleInformationDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SearchVehicleInformationPanelController {
    mainClass driver = new mainClass();
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
    public static ObservableList<Vehicle> results = FXCollections.observableArrayList();
    VehicleInformationDAO vehicleTest = new VehicleInformationDAO();

    @FXML
    void GoBackToEmpOptions(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void SearchVehicleInfo(ActionEvent event) throws IOException {
        /* create conditional once search page is complete so that if a vehicle
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
        
        results = FXCollections.observableArrayList(vehicleTest.vehicleSearchResultHelper(query, dealQuery));

        if(results.isEmpty()){
            driver.changeScene("OrderVehiclePage.fxml");
        }
        else{
            driver.changeScene("SearchVehicleInfoResultPanel.fxml");
        }
    }

    @SuppressWarnings("exports")
    public ObservableList<Vehicle> getResults(){
        return results;
    }

    
}
