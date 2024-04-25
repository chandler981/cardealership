/*
 * Author:       Chandler Ward
 * Written:      2 / 13 / 2024
 * Last Updated: 4 / 25 / 2024
 * 
 * Compilation:  javac driverClass.java
 * Execution:    java driverClass
 * 
 * This file and class handles the actual portion
 * of displaying the results of a search from the 
 * search vehicle page.
 *  
 * % java driverClass
 */

package org.dealership.controllerClasses;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.dealership.mainClass;
import org.dealership.Entities.Vehicle;
import org.dealership.backend.VehicleInformationDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehicleInfoFromSearchController implements Initializable{
    
    @FXML
    private TableColumn<Vehicle, String> AvailabilityColumn;
    
    @FXML
    private TableColumn<Vehicle, String> DiscountColumn;
    
    @FXML
    private TableColumn<Vehicle, String> PurchaseFromColumn;
    
    @FXML
    private TableColumn<Vehicle, String> TransmissionColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleColorColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleMilesColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleMakeColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleModelColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleTypeColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleYearColumn;
    
    @FXML
    private TableColumn<Vehicle, String> VehiclePrice;
    
    @FXML
    private TableColumn<Vehicle, String> VehicleCondition;
    
    @FXML
    private TableView<Vehicle> tableShowingResults;
    
    mainClass driver = new mainClass();
    VehicleInformationDAO vehicleTest = new VehicleInformationDAO();
    ObservableList<Vehicle> results = FXCollections.observableArrayList();
    ObservableList<Vehicle> dealResults = FXCollections.observableArrayList();
    String queryUsed;
    
    /*
     * Method was used to test table when trying to get it to work properly, can be
     * removed in future.
     */
    @FXML
    void TestingQueryToDisplay(ActionEvent event) {

    }
    
    /*
     * This method will take the results from the SQL query and assign it to the correlating 
     * cell in the table. 
     * It does this by taking an observable list, similar to a list, then uses that to apply it
     * to the tables cells. 
     * It utilizes the FXCollections library that is in JavaFX.
     * The properties in the PropertyValueFactory parameters have to be corresponding to a get 
     * method to be able to pull info to apply correctly.
     */

    @Override
    public void initialize(URL location, ResourceBundle resources)
        {
        SearchVehicleInformationPanelController query = new SearchVehicleInformationPanelController();
        this.results = query.getResults();

        System.out.println("Else statement to show results is entered.");
        VehicleMakeColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleMake"));
        VehicleModelColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleModel"));
        VehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleType"));
        VehicleColorColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleColor"));
        AvailabilityColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleAvail"));
        VehicleYearColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleYear"));
        TransmissionColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleTransmission"));
        VehicleMilesColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleMiles"));
        VehicleCondition.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleCondition"));
        VehiclePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehiclePrice"));
        DiscountColumn.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("VehicleDiscount"));
        
        //this sets the table with the correct items and displays it
        tableShowingResults.setItems(this.results);
    }       


    @FXML
    void GoBack(ActionEvent event) throws IOException {
        driver.changeScene("EmployeeOptionsPanel.fxml");
    }

    @FXML
    void GoToRecordCustInfo(ActionEvent event) throws IOException {
        driver.changeScene("RecordCustomerInfoPanel.fxml");
    }
}
